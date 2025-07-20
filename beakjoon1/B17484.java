package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17484 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] dp = new int[n][m][3]; //0 1 2 왼 중 오 같은방향으로 못감
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<m;j++) {
				for(int k = 0; k<3;k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		for(int i = 0; i<m;i++) {
			for(int j = 0; j<3;j++) {
				dp[0][i][j] = arr[0][i];
			}
		}
		
		
		for(int i = 1; i<n;i++) {
			for(int j = 0;j<m;j++) {
				//왼쪽에서 오는 길
				//i 가 x j 가 y
				if(j!=0) {
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+arr[i][j];
				}
				//가운데 오는ㄱ딜
				dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
				
				if(j!=m-1) {
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+arr[i][j];
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<m;i++) {
			for(int j=0;j<3;j++) {
				result = Math.min(result, dp[n-1][i][j]);
			}
		}
		System.out.println(result);
	}
}
