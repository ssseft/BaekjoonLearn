package beakjoon1;
import java.util.Scanner;

public class B1904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i<n+1;i++) {
			dp[i] = ((dp[i-1]+dp[i-2])%15746);
		}
		System.out.println(dp[n]);
	}
}