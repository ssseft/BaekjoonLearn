package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[n][10][1024];
		//1차원은 자리 수, 2차원은 현재 수, 3차원은 비트마스킹(현재까지 나온 수)
		
		for(int i= 1; i<10;i++) {
			int bit = 1<<i;
			dp[0][i][bit] = 1;
		}
		
		for(int i = 1;i<n;i++) {
			for(int j = 0;j<1024;j++) {
				for(int k = 0; k<10;k++) {
					if(dp[i-1][k][j]==0) continue;
					
					if(k>0) {
						int bitmask = j|(1<<(k-1));
						dp[i][k-1][bitmask] += dp[i-1][k][j];
						dp[i][k-1][bitmask] %= 1000000000;
					}
					
					if(k < 9) {
		                int bitmask = j | (1 << (k + 1));
		                dp[i][k+1][bitmask] += dp[i-1][k][j];
		                dp[i][k+1][bitmask] %= 1000000000;
		            }
				}
				
			}
		}
		
		long result = 0;
		for(int i = 0; i<10;i++) {
			result += dp[n-1][i][1023];
			result %= 1000000000;
		}
		
		
		System.out.println(result);
		
	}
}
