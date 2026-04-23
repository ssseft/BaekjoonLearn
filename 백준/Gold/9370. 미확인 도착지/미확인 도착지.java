import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<int[]>[] list;
	static PriorityQueue<int[]> q = new PriorityQueue<>((a1,b1)->a1[1]-b1[1]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int e = Integer.parseInt(br.readLine());
		
		for(int a =0;a<e;a++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			
			for(int i =1;i<=n;i++) {
				list[i] = new ArrayList<>();
			}
			
			int gh_dist = 0;
			for(int i =0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				list[start].add(new int[] {end,value});
				list[end].add(new int[] {start,value});
				if((start==g&&end==h)||(start==h&&end==g)) gh_dist = value;
			}
			
			int[] goal = new int[t];
			for(int i =0;i<t;i++) {
				goal[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(goal);
			
			
			int[] dij_s = dij(s);
			int[] dij_g = dij(g);
			int[] dij_h = dij(h);
			
			for(int x : goal) {
				int v1 = dij_s[g]+dij_h[x]+gh_dist;
				int v2 = dij_s[h]+dij_g[x]+gh_dist;
				if(dij_s[x]==Math.min(v1, v2)) sb.append(x+" ");
			}
			
			
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
	static int[] dij(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist,100_000_000);
		dist[start]= 0;
		q.add(new int[] {start,0});

		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curvalue = c[1];
			if(dist[curnode]<curvalue) continue;
			
			for(int[] next : list[curnode]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				
				if(dist[nextnode]>dist[curnode]+nextvalue) {
					dist[nextnode] = dist[curnode]+nextvalue;
					q.add(new int[] {nextnode,dist[nextnode]});
				}
			}
		}
		return dist;
	}
}