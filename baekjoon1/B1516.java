package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n+1];
		int[] degree = new int[n+1];
		int[] dp = new int[n+1];
		List<Integer>[] list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			value[i] = v;
			while(st.hasMoreTokens()) {
				int c = Integer.parseInt(st.nextToken());
				if(c==-1) break;
				list[c].add(i);
				degree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			if(degree[i] ==0) {
				dp[i] = value[i];
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int next : list[c]) {
				degree[next]--;
				if(degree[next]==0) {
					q.add(next);
				}
				dp[next] = Math.max(dp[next],dp[c]+value[next]);
			}
		}
		
		StringBuilder sb=  new StringBuilder();
		
		for(int i = 1;i<=n;i++) {
			sb.append(dp[i]+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
