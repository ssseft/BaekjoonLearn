import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int w = sc.nextInt();
		int[][] dp = new int[t+1][w+1];
		
		for(int i = 1;i<=t;i++) {
			int c = sc.nextInt();
			for(int j = 0;j<=w;j++) {
				if(j==0) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
				if(c==1&&j%2==0) dp[i][j]++;
				if(c==2&&j%2==1) dp[i][j]++;
			}
		}
		
		int max = 0;
		for(int i = 0;i<=w;i++) {
			max = Math.max(max, dp[t][i]);
		}
		System.out.println(max);
	}
}
