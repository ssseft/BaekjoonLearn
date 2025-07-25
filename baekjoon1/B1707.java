package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			List<Integer>[] graph = new ArrayList[v+1];
			for(int j=1;j<v+1;j++) {
				graph[j] = new ArrayList<>();
			}
			boolean[] visited = new boolean[v+1];
			for(int j =0;j<e;j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				graph[end].add(start);
			}
			Queue<Integer> q = new LinkedList<>();
			
			int[] color = new int[v+1];
			boolean check = false;
		
			for(int j = 1;j<v+1;j++) {
				if(!visited[j]) {
					q.add(j);
					color[j] = 1;
					visited[j] = true;
					
					while(!q.isEmpty()) {
						int c = q.poll();
						
						for(int k : graph[c]) {
							if(!visited[k]) {
								color[k] = color[c]*-1;
								visited[k] = true;
								q.add(k);
							}
							else if(color[k]==color[c]) {
								check = true;
							}
						}
					}
				}
			}
			
			if(check) {
				sb.append("NO\n");
			}
			else {
				sb.append("YES\n");
			}
			
		}
		System.out.print(sb.toString().trim());
	}
}
