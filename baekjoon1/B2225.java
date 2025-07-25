package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[][] dp =  new long[n+1][k+1];
		
		for(int i = 1;i<n+1;i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1;i<n+1;i++) {
			for(int j = 1;j<k+1;j++) {
				dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;
			}
		}
		
		System.out.println(dp[n][k]);
		
	}
}
