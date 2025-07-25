package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B32635 {
	static int[] unf;
	
	public static int Find(int v){
		if(v==unf[v]) return v;
		else return unf[v]=Find(unf[v]);
	}
	public static void Union(int a, int b){
		int fa=Find(a);
		int fb=Find(b);
		if(fa!=fb) unf[fa]=fb;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		unf=new int[n+1];
		st = new StringTokenizer(br.readLine());
		List<int[]>[] list = new ArrayList[n+1];
		List<Integer>[] parents = new ArrayList[n+1];
		int[] value = new int[n+1];
		for(int i = 1;i<n+1;i++) {
			list[i] = new ArrayList<>();
			parents[i] = new ArrayList<>();
			unf[i] = i;
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end,v});
		}
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[s] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
		q.add(new int[] {0,s});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int d = c[0];
			int u = c[0];
			
			if(d>dist[u]) continue;
			
			for(int[] next : list[u]) {
				int v = next[0];
				int w = next[1];
				if(dist[v]>dist[u]+w) {
					dist[v] = dist[u]+w;
					parents[v].clear();
					parents[v].add(u);
					q.add(new int[] {dist[v],v});
				}
				else if(dist[v]==dist[u]+w) {
					parents[v].add(u);
				}
			}
		}
	}
}
