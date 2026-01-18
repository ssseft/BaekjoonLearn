import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[n];
		for(int i = 0;i<n;i++) 
			list[i] = new ArrayList<>();
		
		int[] dij = new int[n];
		for(int i = 0;i<n;i++) 
			dij[i] = -1;
		
		dij[start] = Integer.MAX_VALUE;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
		q.add(new int[] {start,Integer.MAX_VALUE});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[1]!=dij[c[0]]) continue;
			if(c[0]==end) break;
			
			for(int[] next : list[c[0]]) {
				int v = next[0];
				int w = next[1];
				int min = Math.min(w, c[1]);
				if(min>dij[v]) {
					dij[v] = min;
					q.add(new int[] {v,min});
				}
			}
			
		}
		System.out.print(dij[end]);
	}
}
