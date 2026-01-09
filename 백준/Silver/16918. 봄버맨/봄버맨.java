import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		int[][] bomb = new int[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(arr[i][j]=='O') {
					bomb[i][j] = 2;
				}
				else {
					bomb[i][j] = -1;
				}
			}
		}
		
		int[] dx = {1,-1,0,0,0};
		int[] dy = {0,0,1,-1,0};
		for(int s = 2;s<=t;s++) {
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					if(bomb[i][j]>0) bomb[i][j]--;
				}
			}
			
			if(s%2==0) {
				for(int i = 0;i<n;i++) {
					for(int j = 0;j<m;j++) {
						if(bomb[i][j]==-1) bomb[i][j] = 3;
					}
				}
			}
			else {
				q.clear();
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < m; j++) {
	                    if (bomb[i][j] == 0) q.add(new int[] {i, j});
	                }
	            }

	            while (!q.isEmpty()) {
	                int[] cur = q.poll();
	                int x = cur[0], y = cur[1];
	                for (int k = 0; k < 5; k++) {
	                    int cx = x + dx[k];
	                    int cy = y + dy[k];
	                    if (cx >= 0 && cy >= 0 && cx < n && cy < m) bomb[cx][cy] = -1;
	                }
	            }
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				sb.append(bomb[i][j] ==-1 ? '.':'O');
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
