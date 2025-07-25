package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		int n;
		int[][] arr;
		int[][] loopy;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		Queue<int[]> q = new LinkedList<>();
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			arr = new int[n][n];
			loopy = new int[n][n];
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(loopy[i],Integer.MAX_VALUE);
				for(int j=  0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			loopy[0][0] = arr[0][0];
			q.add(new int[] {0,0,arr[0][0]});
			while(!q.isEmpty()) {
				int[] c = q.poll();
				for(int i = 0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<n) {
						if(c[2]+arr[cx][cy]<loopy[cx][cy]) {
							loopy[cx][cy] = c[2]+arr[cx][cy];
							q.add(new int[] {cx,cy,loopy[cx][cy]});
						}
					}
				}
			}
			sb.append("Problem "+t+++": "+loopy[n-1][n-1]+"\n");
		}
		System.out.println(sb.toString().trim());
	}
		
}
