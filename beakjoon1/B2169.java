package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n][m];
		st = new StringTokenizer(br.readLine());
		dp[0][0] = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		arr[0] = dp[0][0];
		for(int i = 1;i<m;i++) {
			int c = Integer.parseInt(st.nextToken());
			arr[i] = c;
			dp[0][i] = dp[0][i-1]+c;
		}
		
		int[] left = new int[m];
		int[] right = new int[m];
		
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			//왼쪽으로 가는 길
			left[0] = dp[i-1][0]+arr[0];
			for(int j = 1;j<m;j++) {
				left[j] = Math.max(left[j-1], dp[i-1][j])+arr[j];
			}
			//오 가 길
			right[m-1] = dp[i-1][m-1]+arr[m-1];
			for(int j = m-2;j>=0;j--) {
				right[j] = Math.max(right[j+1], dp[i-1][j])+arr[j];
			}
			for(int j = 0;j<m;j++) {
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		
	}
}
