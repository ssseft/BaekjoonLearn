package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2665 {
	static int n;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		int change = 0;
		
		for(int i = 0;i<n;i++) {
			String line = br.readLine();
			for(int j = 0;j<n;j++) {
				arr[i][j] = line.charAt(j)-'0';
				if(arr[i][j]==0) change++;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[n][n][251];
		
		q.add(new int[] {0,0,0});
		visited[0][0][0]=true;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[0]==n-1&&c[1]==n-1) {
				min = Math.min(min, c[2]);
				continue;
			}
			
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				
				if(cx>=0&&cy>=0&&cx<n&&cy<n) {
					if(arr[cx][cy]==0) {
						if(c[2]>=min) continue;
						if(!visited[cx][cy][c[2]+1]) {
							visited[cx][cy][c[2]+1] = true;
							q.add(new int[] {cx,cy,c[2]+1});
						}
					}
					else {
						if(!visited[cx][cy][c[2]]) {
							visited[cx][cy][c[2]]  = true;
							q.add(new int[] {cx,cy,c[2]});
						}
						
					}
				}
			}
		}
		System.out.println(min);
	}
}
