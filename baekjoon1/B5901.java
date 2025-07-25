package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B5901 {
	static int n,m,k;
	static int[] market;
	static List<int[]>[] list;
	static int[][] dij;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		market = new int[k];
		for(int i = 0;i<k;i++) {
			market[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[f].add(new int[] {t,v});
			list[t].add(new int[] {f,v});
		}
		
		dij = new int[k][n+1];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		
		for(int i = 0;i<k;i++) {
			Arrays.fill(dij[i], Integer.MAX_VALUE);
			dij[i][market[i]] = 0;
			q.add(new int[] {market[i],0});
			while(!q.isEmpty()) {
				int[] c = q.poll();
				int curnode = c[0];
				int curcost = c[1];
				if(curcost>dij[i][curnode]) continue;
				for(int[] next : list[curnode]) {
					int nextnode = next[0];
					int nextcost = next[1];
					if(dij[i][nextnode]>dij[i][curnode]+nextcost) {
						dij[i][nextnode] = dij[i][curnode]+nextcost;
						q.add(new int[] {nextnode,dij[i][curnode]+nextcost});
					}
				}
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[k];
		for(int i = 1;i<=n;i++) {
			boolean pass = false;
			for(int j = 0;j<k;j++) if(market[j]==i) pass = true;
			if(pass) continue;
			recursion(0,i,0,i);
		}
		System.out.print(min);
	}
	static void recursion(int value,int x,int cnt,int cur) {
		if(cnt==k) {
			value += dij[getmarket(cur)][x];
			min = Math.min(min, value);
			return;
		}
		
		
		
		for(int i = 0;i<k;i++) {
			if(!visited[i]) {
				visited[i] = true;
				int next = market[i];
				recursion(value+dij[getmarket(next)][cur],x,cnt+1,next);
				visited[i] = false;
			}
		}
	}
	static int getmarket(int node) {
		for(int i = 0;i<k;i++) {
			if(market[i]==node) return i;
		}
		return 0;
	}
}
