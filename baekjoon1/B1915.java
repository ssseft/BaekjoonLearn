package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B1915 {
	static boolean check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr = new String[n];
		int[][] dp = new int[n][m];
		int max = 0;
		for(int i =0 ;i<n;i++) {
			arr[i] = br.readLine();
			for(int j = 0; j<m;j++) {
				if(arr[i].charAt(j)=='1') {
					dp[i][j] = 1;
					max = 1;
				}
			}
		}
		
		for(int i = 1; i<n;i++) {
			for(int j =1; j<m;j++) {
				if(dp[i][j]==1) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1])+1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max*max);
	}
}
