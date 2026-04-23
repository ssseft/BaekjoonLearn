import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] dp = new int[n+1];
		if(n%2==1) {
			System.out.print(0);
			return;
		}
		dp[0] = 1;
		dp[2] = 3;
		int sum = 1;
		for(int i = 4; i<=n;i+=2) {
			dp[i] = dp[i-2]*3+sum*2;
			sum += dp[i-2];
		}
		System.out.print(dp[n]);
	}
}
