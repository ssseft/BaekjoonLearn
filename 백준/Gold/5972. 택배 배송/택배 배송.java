import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]> list[] = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) list[i] = new ArrayList<>();
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
		}
		
		int[] dij = new int[n+1];
		Arrays.fill(dij, 1_000_000_000);
		dij[1] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {1,0});
		while(!pq.isEmpty()) {
			int[] c = pq.poll();
			int curnode = c[0];
			int curvalue = c[1];
			for(int[] next : list[c[0]]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				if(dij[nextnode]>curvalue+nextvalue) {
					dij[nextnode] = curvalue+nextvalue;
					pq.add(new int[] {nextnode,dij[nextnode]});
				}
			}
		}
		System.out.print(dij[n]);
	}
}
