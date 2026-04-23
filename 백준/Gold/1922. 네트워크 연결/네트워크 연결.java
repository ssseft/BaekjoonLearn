import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int find(int x) {
		if(parent[x]==x) return x;
		else return find(parent[x]);
	}
	static void union(int a,int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1>b1) parent[b1] = a1;
		else parent[a1]	= b1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		
		for(int i = 1;i<=n;i++) parent[i] = i;
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			q.add(new int[] {s,e,v});
		}
		int cost = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int s = c[0];
			int e = c[1];
			if(find(s)==find(e)) continue;
			cost+=c[2];
			union(s,e);
		}
		System.out.print(cost);
	}
}