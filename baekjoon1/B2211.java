package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[n+1];
		int[] di = new int[n+1];
		int[] result = new int[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
			di[i] = Integer.MAX_VALUE;
		}
		di[1] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {t,v});
			list[t].add(new int[] {s,v});
			if(s==1||t==1) {
				pq.add(new int[] {s,t,v});
			}
		}
				
		pq.add(new int[] {1,0});
		
		while(!pq.isEmpty()) {
			int[] c = pq.poll();
			int curnode = c[0];
			int curvalue = c[1];
			if(di[curnode]<curvalue) continue;
			
			for(int[] d : list[curnode]) {
				int nextnode = d[0];
				int nextvalue = d[1];
				if(di[nextnode]>di[curnode]+nextvalue) {
					di[nextnode] = di[curnode]+nextvalue;
					pq.add(new int[] {nextnode,di[nextnode]});
					result[nextnode] = curnode;
				}
			}
		}
		
		System.out.println(n-1);
		for(int i = 2;i<=n;i++) {
			System.out.println(i+" "+result[i]);
		}
	}
}
