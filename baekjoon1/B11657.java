package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B11657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			st  = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
		}
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		for(int i = 1;i<n;i++) {
			for(int j =1;j<=n;j++) {
				for(int[] c : list[j]) {
					int nextnode = c[0];
					int value = c[1];
					if(dist[j]!=Long.MAX_VALUE&&dist[j]+value<dist[nextnode]) {
						dist[nextnode] = dist[j]+value;
					}
				}
			}
			
		}
		
		long[] check = new long[n+1];
		check = dist.clone();
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<=n;j++) {
				for(int[] c : list[j]) {
					int nextnode = c[0];
					int value = c[1];
					if(check[j]!=Long.MAX_VALUE&&check[j]+value<check[nextnode]) {
						check[nextnode] = check[j]+value;
					}
				}
			}
		}
		
		
		for(int i =1;i<=n;i++) {
			if(dist[i]!=check[i]) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int i = 2;i<=n;i++) {
			if(dist[i]==Long.MAX_VALUE) {
				System.out.println(-1);
			}
			else System.out.println(dist[i]);
		}
	}
}
