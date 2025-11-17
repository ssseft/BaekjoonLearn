import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] degree = new int[n+1];
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			for(int j = 0;j<t-1;j++) {
				int c = Integer.parseInt(st.nextToken());
				list[s].add(c);
				degree[c]++;
				s = c;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1;i<=n;i++) {
			if(degree[i]==0) q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!q.isEmpty()) {
			int c = q.poll();
			sb.append(c+"\n");
			cnt++;
			for(int next : list[c]) {
				degree[next]--;
				if(degree[next]==0) {
					q.add(next);
				}
			}
		}
		
		if(cnt==n) System.out.print(sb);
		else System.out.print(0);
	}
}
