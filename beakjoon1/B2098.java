package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2098 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] city = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1;j<=n;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][1<<n];
		//[현재 위치][방문한 도시 비트마스크]
		
		for(int i = 1;i<=n;i++) {
			Arrays.fill(dp[i], 100000000);
		}
		
		dp[1][1] = 0;
		
		for(int i = 1;i<(1<<n);i++) {
			for(int c = 1;c<=n;c++) {
				if((i&(1<<(c-1)))==0) continue;
				
				for(int nextcity = 1;nextcity<=n;nextcity++) {
					if(((i&(1<<(nextcity-1)))!=0)||city[c][nextcity]==0) continue;
					
					int next = i|(1<<(nextcity-1));
					dp[nextcity][next] = Math.min(dp[nextcity][next], dp[c][i]+city[c][nextcity]);
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 2;i<=n;i++) {
			if(city[i][1]==0||dp[i][(1<<n)-1]==100000000) continue;
			
			result = Math.min(result, dp[i][(1<<n)-1]+city[i][1]);
		}
		System.out.print(result);
	}
}
