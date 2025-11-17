import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] val = new int[n];
		
		for(int i = 0;i<n;i++) {
			num[i] = sc.nextInt();
			val[i] = sc.nextInt();
		}
		
		int[] dp = new int[c+1];
		Arrays.fill(dp, 999999);
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<=c;j++) {
				if(val[i]<=j) {
					dp[j] = Math.min(dp[j-val[i]]+num[i],dp[j]);
				}
				else {
					dp[j] = Math.min(dp[j], num[i]);
				}
			}
		}
		System.out.print(dp[c-1]);
	}
}