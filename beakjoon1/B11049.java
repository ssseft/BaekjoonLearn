package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n+1][2];
		for(int i = 1; i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n+1][n+1];
		for(int l = 1;l<n;l++) {
			for(int i = 1; i <= n-l ; i++) {
				int j = i+l;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i;k<j;k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+arr[i][0]*arr[k][1]*arr[j][1]);
				}
			}
		}
		System.out.print(dp[1][n]);
	}
}
