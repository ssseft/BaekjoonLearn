import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[][] dp = new long[n+1][10];
		
		for(int i =1;i<10;i++) {
			dp[1][i] = 1;
		}
		int m = 1000000000;
		for(int i =2;i<n+1;i++) {
			for(int j =0; j<10;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][1]%m;
				}
				else if(j==9) {
					dp[i][j] = dp[i-1][8]%m;
				}
				else {
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]%m);
				}
			}
		}
		long result = 0;
		for(int i =0; i<10;i++) {
			result= (result+dp[n][i])%m;
		}
		System.out.print(result);
	}
}