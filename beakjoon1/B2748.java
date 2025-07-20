package beakjoon1;
import java.util.Scanner;

public class B2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		long[] dp = new long[91];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i<=90;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
