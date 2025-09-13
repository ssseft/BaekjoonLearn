import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[n][m];
		
		long[] left,right,Lsum,Rsum;
		Lsum = new long[m];
		Rsum = new long[m];
		Lsum[0] =arr[0][0];
		Rsum[m-1] = arr[0][m-1];
		
		for(int i = 1;i<m;i++) Lsum[i] = Math.max(Lsum[i-1]+arr[0][i],arr[0][i]);
		for(int i = m-2;i>=0;i--) Rsum[i] = Math.max(Rsum[i+1]+arr[0][i],arr[0][i]);
		for(int i = 0;i<m;i++) {
			dp[0][i] = Lsum[i] + Rsum[i] - arr[0][i];
		}
		
		for(int i = 1;i<n;i++) {
			Lsum[0] =arr[i][0];
			Rsum[m-1] = arr[i][m-1];
			for(int j = 1;j<m;j++) Lsum[j] = Math.max(Lsum[j-1]+arr[i][j],arr[i][j]);
			for(int j = m-2;j>=0;j--) Rsum[j] = Math.max(Rsum[j+1]+arr[i][j],arr[i][j]);
			
			left = new long[m];
			right = new long[m];
			
			left[0] = dp[i-1][0]+Lsum[0];
			right[m-1] = dp[i-1][m-1]+Rsum[m-1];
			
			for(int j = 1;j<m;j++) {
				left[j] = Math.max(left[j-1]+arr[i][j],dp[i-1][j]+Lsum[j]);
			}
			
			for(int j = m-2;j>=0;j--) {
				right[j] = Math.max(right[j+1]+arr[i][j], dp[i-1][j]+Rsum[j]);
			}
			
			for(int j = 0;j<m;j++) {
				dp[i][j] = Math.max(left[j]+Rsum[j], right[j]+Lsum[j])-arr[i][j];
			}
		}
		long max = Long.MIN_VALUE;
		for(int i = 0;i<m;i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		System.out.println(max);
	}
}
