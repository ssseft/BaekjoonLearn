package beakjoon1;
import java.util.Scanner;

public class B11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[][] dp = new int [n+1][10];
		for(int i =1; i<=n;i++) {
			dp[i][0] = 1;
		}
		
		for(int i =1; i<=n;i++) {
			for(int j =1;j<10;j++) {
				dp[i][j] = (dp[i][j-1]+dp[i-1][j])%10007;
			}
		}
		int sum=0;
		for(int i = 0;i<10;i++) {
			sum+=dp[n][i];
		}
		System.out.print(sum%10007);
	}
}
