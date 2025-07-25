package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B25378 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i = 0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int[] dp = new int[n+1];
		
		
		for(int i = 1;i<=n;i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			int c = list.get(i);
			for(int j = i+1;j<=n;j++) {
				if(list.get(j)<c) break;
				if(list.get(j)==c) {
					dp[j] = Math.max(dp[j], dp[i-1]+1);
					break;
				}
				
				c = list.get(j)-c;
			}
		}
		
		System.out.print(n-dp[n]);
		
	}
}
