import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int idx = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			int[][] arr = new int[n][n];
			for(int i=  0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] lose = new int[n][n];
			for(int i = 0;i<n;i++) {
				Arrays.fill(lose[i], Integer.MAX_VALUE);
			}
			
			lose[0][0] = arr[0][0];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {0,0,arr[0][0]});
			while(!q.isEmpty()) {
				int[] c = q.poll();
				for(int i =0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<n) {
						if(c[2]+arr[cx][cy]<lose[cx][cy]) {
							lose[cx][cy] = c[2]+arr[cx][cy];
							q.add(new int[] {cx,cy,lose[cx][cy]});
						}
					}
				}
			}
			
			sb.append("Problem "+idx+++": "+lose[n-1][n-1]+"\n");
		}
		System.out.println(sb);
	}
}
