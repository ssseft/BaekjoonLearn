import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+10];
		
		dp[1] = 1;
		dp[2] = 3;
		if(n<3) {
			System.out.print(dp[n]);
		}
		else {
			for(int i =3; i<=n; i++) {
				dp[i] = (dp[i-1]+ 2*dp[i-2])%10007;
			}
			System.out.print(dp[n]);
		}
		sc.close();
	}
}