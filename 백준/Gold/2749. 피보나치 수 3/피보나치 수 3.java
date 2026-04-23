import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int num = 0;
		for(int i = 0; i<n.length();i++) {
			int idx = n.charAt(i)-'0';
			num = (num*10+idx)% 1500000;
		}
		int[] dp = new int[num+1];
		dp[1] = 1;
		for(int i = 2; i<num+1;i++	) {
			dp[i] = dp[i-1]+dp[i-2];
			if(dp[i]>1000000) dp[i] %=1000000;
		}
		System.out.print(dp[num]);
	}
}
