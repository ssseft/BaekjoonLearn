package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {
	static int[][] dp;
	static int[][] num;
	static int n;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dp = new int[n+1][n+1];
		num = new int[n+1][n+1];
		for(int i = 1 ;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n;j++) {
				int c = Integer.parseInt(st.nextToken());
				num[i][j] = c;
			}
		}
		int result = -1;
		for(int i = 1; i<=n;i++) {
			for(int j = 1; j<=n;j++) {
				if(dp[i][j] == 0) {
					DFS(i,j);
				}
				if(dp[i][j]>result) {
					result = dp[i][j];
					System.out.println(i+" "+j+" "+result);
				}
			}
		}
		System.out.print(result);
		
	}
	static void DFS(int x, int y) {
		if(dp[x][y]!=0) return;
		dp[x][y] = 1;
		
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>0&&cy>0&&cx<=n&&cy<=n&&num[x][y]<num[cx][cy]) {
				if(dp[cx][cy]==0) DFS(cx,cy);
				dp[x][y] = Math.max(dp[x][y], 1+dp[cx][cy]);
			}
		}
	}
}
