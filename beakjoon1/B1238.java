package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[n+1][n+1];
		List<int[]>[] list = new ArrayList[n+1];
		
		for(int i = 1;i<n+1;i++) {
			list[i] = new ArrayList<>();
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		
		
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end,value});
		}
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		
		for(int i = 1;i<n+1;i++) {
			graph[i][i] = 0;
			q.add(new int[] {i,0});
			while(!q.isEmpty()) {
				int[] c = q.poll();
				int curdist = c[1];
				int curnode = c[0];
				if(curdist>graph[i][curnode]) continue;
				for(int[] d : list[curnode]) {
					int nextnode=  d[0];
					int nextdist=  d[1];
					if(graph[i][nextnode]>graph[i][curnode]+nextdist) {
						graph[i][nextnode] = graph[i][curnode]+nextdist;
						q.add(new int[] {nextnode,graph[i][nextnode]});
					}
				}
			}
		}
		
		int max = -1;
		
		for(int i = 1;i<n+1;i++) {
			max = Math.max(max, graph[i][x]+graph[x][i]);
		}
		System.out.print(max);
	}
}
