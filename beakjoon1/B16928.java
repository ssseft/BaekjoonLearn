package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16928 {
	static boolean[] visited;
	static List<int[]> up;
	static List<int[]> down;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		up = new ArrayList<>();
		down = new ArrayList<>();
		visited = new boolean[101];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			up.add(new int[] {start,end});
		}
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			down.add(new int[] {end,start});
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1,0});
		
		int result = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[0]==100) {
				result = c[1];
				break;
			}
			
			for(int i = 1;i<=6;i++) {
				int cx = c[0]+i;
				if(cx<101&&!visited[cx]) {
					boolean check = false;
					for(int[] p : up) {
						if(p[0]==cx) {
							q.add(new int[] {p[1],c[1]+1});
							visited[p[1]] = true;
							check = true;
							break;
						}
					}
					if(!check) {
						for(int[] p : down) {
							if(p[0]==cx) {
								q.add(new int[] {p[1],c[1]+1});
								visited[p[1]] = true;
								check = true;
								break;
							}
						}
					}
					
					if(!check) {
						visited[cx] = true;
						q.add(new int[] {cx,c[1]+1});
					}
				}
			}
			
		}
		
		System.out.println(result);
	}
}
