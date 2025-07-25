package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B11052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i =1; i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i =1 ;i<=n;i++) {
			for(int j = 1; j<=i;j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
			}
		}
		System.out.print(dp[n]);
	}
}