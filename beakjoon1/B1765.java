package beakjoon1;

import java.io.*;
import java.util.*;

public class B1765 {
	static int[] arr;
	static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			arr[a] = b;
		}
	}
	static int find(int x) {
		if(x==arr[x]) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}
	static List<Integer>[] fr;
	static List<Integer>[] en;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		fr = new ArrayList[n+1];
		en = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			arr[i] = i;
			fr[i] = new ArrayList<>();
			en[i] = new ArrayList<>();
		}
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			char r = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(r=='F') {
				fr[a].add(b);
				fr[b].add(a);
			}
			else {
				en[a].add(b);
				en[b].add(a);
			}
		}
		
		for(int i = 1;i<=n;i++) {
			for(int j : fr[i]) {
				union(i,j);
			}
			for(int j : en[i]) {
				for(int k : en[j]) {
					union(i,k);
				}
			}
		}
		
		int cnt = 0;
		boolean[] u = new boolean[n+1];
		for(int i = 1;i<=n;i++) {
			if(!u[arr[i]]) {
				cnt++;
				u[arr[i]] = true;
			}
		}
		System.out.print(cnt);
	}
}
