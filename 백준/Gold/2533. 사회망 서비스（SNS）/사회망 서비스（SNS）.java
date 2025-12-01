import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[][] dp;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n+1];
        
        for(int i =1;i<=n;i++) list[i] = new ArrayList<>();
        
        for(int i = 0;i<n-1;i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	list[s].add(e);
        	list[e].add(s);        	
        }
        
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        recur(1);
        
        System.out.print(Math.min(dp[1][0], dp[1][1]));
	}
	static void recur(int c) {
		visited[c] = true;
		dp[c][1] = 1;
		for(int next : list[c]) {
			if(!visited[next]) {
				recur(next);
				dp[c][0] += dp[next][1];
				dp[c][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
}
