import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		for(int i =1; i<=n;i++) {
			for(int j =1;j<=n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		long[][][] dp = new long[n+1][n+1][3]; // 0은 왼쪽 1은 위 2는 대각선
		dp[1][2][0] = 1;
		for(int i =1; i<=n;i++) {
			for(int j =3;j<=n;j++) {
				if(arr[i][j]==0) {
					dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2];
					dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2];
					if(arr[i-1][j]==0&&arr[i][j-1]==0) {
						dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
					}
				}
			}
		}
		System.out.print(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
	}
}