package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1102 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String onoff = br.readLine();
		int p = Integer.parseInt(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		int[][] dp = new int[n+1][1<<(n+1)];
		for(int i = 1;i<=n;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); // 초기화
        }
		
		
		int bit = 0;
		for(int i = 0;i<onoff.length();i++) {
			if(onoff.charAt(i)=='Y') bit = (bit|(1<<i));
		}
		int cnt = 0;
		for(int i = 0;i<onoff.length();i++) {
			if(onoff.charAt(i)=='Y') {
				dp[i+1][bit] = 0;
				cnt++;
				q.add(new int[] {i+1,bit});
			}
		}
		if(cnt>=p) {
			System.out.print(0);
			return;
		}
		
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0;i<size;i++) {
				int[] c= q.poll();
				int cur = c[0];
				int onpower = c[1];
				for(int j = 0;j<n;j++) {
					if((onpower&(1<<j))==0) {
						int next = onpower|(1<<j);
						int mincost = Integer.MAX_VALUE;
						
						for(int k =0;k<n;k++) {
							if((onpower&(1<<k))!=0) {
								mincost = Math.min(mincost, arr[k+1][j+1]);
							}
						}
						if(dp[j+1][next] >dp[cur][onpower]+mincost) {
							dp[j+1][next] = dp[cur][onpower]+mincost;
							q.add(new int[] {j+1,next});
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1;i<=n;i++) {
			for(int j = 0;j<(1<<n);j++) {
				if(Integer.bitCount(j)>=p) {
					min = Math.min(min, dp[i][j]);
				}
			}
		}
		
		if(min==Integer.MAX_VALUE) {
			System.out.print(-1);
		}
		else {
			System.out.print(min);
		}
	}
}
