import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][3];
		for(int i = 0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		
		int[][] dp = new int[n][3];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0;i<3;i++) {
			dp[0][0] = dp[0][1] = dp[0][2] = 9999;
		    dp[0][i] = arr[0][i];
			for(int j = 1;j<n;j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
			}
			for(int j = 0;j<3;j++) {
				if(i==j) continue;
				min = Math.min(min, dp[n-1][j]);
			}
		}
		System.out.print(min);
	}
}
