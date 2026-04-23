import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st,st2;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] bite = new int[n];
		int[] cost = new int[n];
		
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			bite[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
		}
		
		int[][] dp= new int[n+1][10001];
		
		for(int i = 1;i<=n;i++) {
			for(int j = 0;j<=10000;j++) {
				dp[i][j] = dp[i-1][j];
			}
			
			for(int j = cost[i-1];j<=10000;j++) {
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i-1]]+bite[i-1]);
			}
		}
		
		for(int i = 0;i<10001;i++) {
			if(dp[n][i]>=m) {
				System.out.print(i);
				return;
			}
		}
	}
}