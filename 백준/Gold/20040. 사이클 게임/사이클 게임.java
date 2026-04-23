import java.io.*;
import java.util.*;

public class Main {
	static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1<b1) parent[b1] = parent[a1];
		else parent[a1] = parent[b1];
	}
	static int find(int x) {
		if(x==parent[x]) return x;
		else return find(parent[x]);
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for(int i = 0;i<n;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(find(s)==find(e)){
				System.out.print(i);
				return;
			}
			union(s,e);
		}
		System.out.print(0);
	}
}