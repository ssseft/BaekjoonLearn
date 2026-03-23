import java.io.*;
import java.util.*;

public class Main {
	static int find(int x) {
		if(x==parent[x]) return x;
		return find(parent[x]);
	}
	static void union(int a,int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1>b1) parent[b1] = a1;
		else parent[a1]	= b1;
	}
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		for(int i = 1;i<=v;i++) parent[i] = i;
		for(int i = 0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.add(new int[] {a,b,c});
		}
		long sum = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int start = c[0];
			int end = c[1];
			int value = c[2];
			if(find(start) == find(end)) continue;
			union(start,end);
			sum += value;
		}
		System.out.print(sum);
	}
}