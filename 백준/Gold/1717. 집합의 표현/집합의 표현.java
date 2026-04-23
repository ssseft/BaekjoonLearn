import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota>rootb) parent[rootb] =roota;
		else parent[roota] = rootb;
	}
	static int find(int x) {
		if(parent[x]!=x) parent[x] = find(parent[x]);
		return parent[x];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int qu = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(qu==0) union(a,b);
			else {
				sb.append(find(a)==find(b) ? "YES":"NO").append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
