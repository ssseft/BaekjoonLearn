package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1135 {
	static int[] dp;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		
		dp = new int[n];
		list = new ArrayList[n];
		
		for(int i = 0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1;i<n;i++) {
			list[Integer.parseInt(st.nextToken())].add(i);
		}
		
		System.out.println(dfs(0));
	}
	static int dfs(int c) {
		int max = 0;
		int cnt = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
		for(int next : list[c]) {
			dp[next] = dfs(next);
			pq.add(new int[] {next,dp[next]});
		}
		
		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			max = Math.max(max, node[1]+(++cnt));
		}
		return max;
	}
}
