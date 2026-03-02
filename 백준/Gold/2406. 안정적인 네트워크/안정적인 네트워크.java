import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1>b1) parent[b1] = a1;
		else parent[a1] = b1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 1;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)-> a[2]-b[2]);
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				int v = Integer.parseInt(st.nextToken());
				if(j==1||i<=j) continue;
				q.add(new int[]{i,j,v});
			}
		}
		StringBuilder sb=  new StringBuilder();
		int total = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int v = c[2];
			if(find(x)==find(y)) continue;
			else {
				union(x,y);
				cnt++;
				total+=v;
				sb.append(x+" "+y+"\n");
			}
		}
		System.out.println(total+" "+cnt);
		System.out.print(sb);
	}
}
