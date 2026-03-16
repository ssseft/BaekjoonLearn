import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] dp = new long[2501];
		long mod = 1000000007L;
		dp[1] = 1;
		dp[0] = 1;
		for(int i = 2;i<=2500;i++) {
			for(int j = 0;j<i;j++) {
				dp[i]=(dp[i]+(dp[j]*dp[i-1-j])%mod)%mod;
			}
			dp[i] %= mod;
		}
		
		for(int i =0;i<t;i++) {
			int c = sc.nextInt();
			if(c%2==1) System.out.println(0);
			else System.out.println(dp[c/2]);
		}
	}
}