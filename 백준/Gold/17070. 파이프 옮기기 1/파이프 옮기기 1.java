import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][][] dp = new int[n][n][3];// 0 오른 1대각 2아래
		for (int i = 1; i < n; i++) {
			if(arr[0][i]==1) break;
			dp[0][i][0] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if(arr[i][j]==1) continue;
				
				dp[i][j][0] = dp[i][j-1][1]+dp[i][j-1][0];
				dp[i][j][2] = dp[i-1][j][1]+dp[i-1][j][2];
				
				if(arr[i][j-1]==1||arr[i-1][j]==1) continue;
				dp[i][j][1] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				
			}
		}

		System.out.print(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
}