package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B33941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[50];
		Arrays.fill(dp, -1);
		dp[0]=0;
		for(int i= 0;i<n;i++) {
			int c = Integer.parseInt(br.readLine());
			if(c<500||c>=20000) continue;
			
			c-=500;
			int[] next = dp.clone();
			for(int j = 0;j<50;j++) {
				if(dp[j]!=-1) {
					int e = (j+c/10)%50;
					next[e] = Math.max(next[e], dp[j]+c);
				}
			}
			dp = next;
		}
		System.out.print(dp[0]);
	}
}