package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1398 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[100];
		int[] coins = {1,10,25};
		for (int i = 1; i <= 99; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0; 
		for (int coin : coins) {
            for (int i = coin; i <= 99; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
		for(long i = 0; i<t;i++	) {
			int cnt = 0;
			long num = Long.parseLong(br.readLine());
			while(num!=0) {
				long remainder = num%100;
				cnt+=dp[(int)remainder];
				num /= 100;
				
			}
			sb.append(cnt+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
