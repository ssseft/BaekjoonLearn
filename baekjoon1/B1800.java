package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1800 {
	static PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
	static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<int[]>();
		}
		int left = 0;
		int right = 0;
		for(int i = 0;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
			right = Math.max(right, v);
		}
		
		int answer = -1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(possible(n,k,mid)) {
				answer = mid;
				right = mid-1;
			}
			else left = mid+1;
		}
		
		System.out.print(answer);
	}
	static boolean possible(int n,int k,int mid) {
		q.clear();
		q.add(new int[] {1,0});
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curnum = c[1];
			if(dist[curnode]<curnum) continue;
			for(int[] next : list[curnode]) {
				int nextnode = next[0];
				int nextcost = next[1];
				
				int nextuse = curnum+(nextcost>mid ? 1:0);
				if(nextuse<dist[nextnode]) {
					dist[nextnode] = nextuse;
					q.add(new int[] {nextnode,nextuse});
				}
				
			}
		}
		return dist[n]<=k;
	}
}
