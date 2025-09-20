import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int a = 0;a<t;a++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			char[][] arr = new char[n][m];
			int[] bitmask = new int[n];
			for(int i = 0;i<n;i++) {
				String l = br.readLine();
				int bit = 0;
				for(int j = 0;j<m;j++) {
					arr[i][j] = l.charAt(j);
					if(arr[i][j]=='.') bit += 1<<j;
				}
				bitmask[i] = bit;
			}
			
			int[][] dp = new int[n][1<<m];
			
			for(int i = 0;i<(1<<m);i++) {
				if(((i>>1)&i)!=0) continue;
				if((bitmask[0]&i)==i) {
					dp[0][i] = Integer.bitCount(i);
				}
			}
			
			for(int i = 1;i<n;i++) {
				for(int j = 0;j<(1<<m);j++) {
					if(((j<<1)&j)!=0) continue;
					if((bitmask[i]&j)!=j) continue;
					
					for(int k = 0;k<(1<<m);k++) {
						if((k&(j<<1))!=0) continue;
						if((k&(j>>1))!=0) continue;
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+Integer.bitCount(j));
					}
				}
			}
			
			int max = 0;
			for(int i = 0;i<(1<<m);i++) {
				max = Math.max(max, dp[n-1][i]);
			}
			System.out.println(max);
		}
		
	}
}
