import java.io.*;
import java.util.*;

public class Main {
	static int[] totalperson, parent, candy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		candy = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[n+1];
		totalperson = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			parent[i] = i;
			totalperson[i] = 1;
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int[] dp = new int[k]; 
		boolean[] use = new boolean[n+1];
		
		for(int i = 1;i<=n;i++) {
			int cur = find(i);
			if(use[cur]||k<=totalperson[cur]) continue;
			use[cur] = true;
			for(int j = k-1;j>=totalperson[cur];j--) {
				dp[j] = Math.max(dp[j], dp[j-totalperson[cur]]+candy[cur]);
			}
		}
		
		System.out.print(dp[k-1]);
	}
	
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		return find(parent[x]);
	}
	
	static void union(int a,int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1==b1) return;
		if(a1>b1) {
			int temp = a1;
			a1 = b1;
			b1 = temp;
		}
		parent[b1] = a1;
		candy[a1] += candy[b1];
		totalperson[a1] += totalperson[b1];
	}
}