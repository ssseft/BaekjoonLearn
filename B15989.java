package beakjun;
import java.io.*;

public class B15989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[10001][4];
		int[] result = new int[10001];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		for(int j =4; j<10001;j++) {
			dp[j][1] = 1;
			dp[j][2] = dp[j-2][2]+1;
			dp[j][3] = result[j-3];
			result[j] = dp[j][1]+dp[j][2]+dp[j][3];
		}
		
		
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(result[n]+"\n");
		}
		System.out.print(sb.toString());
	}
}