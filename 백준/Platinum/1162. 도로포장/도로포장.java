import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int city,pack;
		long value;

		public Node(int city, long value,int pack) {
			super();
			this.city = city;
			this.value = value;
			this.pack = pack;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
		}
		long[][] dij = new long[n+1][k+1];
		for(int i = 2;i<=n;i++) {
			Arrays.fill(dij[i], Long.MAX_VALUE);
		}
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Long.compare(a.value,b.value));
		q.add(new Node(1,0,0));
		while(!q.isEmpty()) {
			Node c = q.poll();
			int city = c.city;
			long value = c.value;
			int pack = c.pack;
			if(dij[city][pack]<value) continue;
			for(int[] next : list[city]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				//포장할경우
				if(pack<k&&dij[nextnode][pack+1]>dij[city][pack]) {
					dij[nextnode][pack+1]= dij[city][pack];
					q.add(new Node(nextnode,value,pack+1));
				}
				
				//포장안할경우
				if(dij[nextnode][pack]>dij[city][pack]+nextvalue) {
					dij[nextnode][pack] = dij[city][pack]+nextvalue;
					q.add(new Node(nextnode,value+nextvalue,pack));
				}
			}
		}
		
		long ans = Long.MAX_VALUE;
		for(int i = 0;i<=k;i++) {
			ans = Math.min(ans, dij[n][i]);
		}
		System.out.println(ans);
	}
}