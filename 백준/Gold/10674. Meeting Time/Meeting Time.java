import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list1 = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list1[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list1[a].add(new int[] {b, c, d});
		}
		
		int MAX = 10000;
		boolean[][] dp1 = new boolean[n + 1][MAX + 1]; // 베시
		boolean[][] dp2 = new boolean[n + 1][MAX + 1]; // 엘시
		
		dp1[1][0] = true;
		dp2[1][0] = true;
		
		for(int i = 1; i <= n; i++) {
			for(int t = 0; t <= MAX; t++) {
				if(dp1[i][t]) {
					for(int[] next : list1[i]) {
						int nextnode = next[0];
						int btime = next[1];
						
						if(t+btime<=MAX) dp1[nextnode][t+btime] = true;
					}
				}
				
				if(dp2[i][t]){
					for(int[] next:list1[i]) {
						int nextnode = next[0];
						int etime = next[2];
						
						if(t+etime<=MAX) {
							dp2[nextnode][t+etime]=true;
						}
					}
				}
			}
		}
		for(int t=0;t<=MAX;t++) {
			if(dp1[n][t]&&dp2[n][t]) {
				System.out.print(t);
				return;
			}
		}
		
		System.out.print("IMPOSSIBLE");
	}
}