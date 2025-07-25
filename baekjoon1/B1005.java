package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean[][] route = new boolean[n+1][n+1];
			Queue<Integer> q = new LinkedList<>();
			int[] value = new int[n+1];
			int[] dp = new int[n+1];
			int[] degree = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int a = 1;a<n+1;a++) {
				value[a] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j<k;j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				route[start][end] = true;
				degree[end]++;
			}
			
			for(int j = 1;j<n+1;j++) {
				if(degree[j]==0) {
					dp[j] = value[j];
					q.add(j);
				}
			}
			
			while(!q.isEmpty()) {
				int c = q.poll();
				for(int j = 1;j<n+1;j++) {
					if(route[c][j]) {
						degree[j]--;
						dp[j] = Math.max(dp[j], dp[c]+value[j]);
						route[c][j] = false;
						if(degree[j]==0)q.add(j);
					}
				}
			}
			
			int goal = Integer.parseInt(br.readLine());
			sb.append(dp[goal]+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
