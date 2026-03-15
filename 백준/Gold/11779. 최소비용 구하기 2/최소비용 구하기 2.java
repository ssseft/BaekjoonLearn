import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		List<int[]>[] bus = new ArrayList[n+1];
		List<int[]>[] rebus = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			bus[i] = new ArrayList<int[]>();
			rebus[i] = new ArrayList<int[]>();
		}
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bus[s].add(new int[] {e,v});
			rebus[e].add(new int[] {s,v});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dij = new int[n+1];
		Arrays.fill(dij, Integer.MAX_VALUE);
		
		dij[start] = 0;
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		q.add(new int[] {start,0});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curvalue = c[1];
            if(curvalue > dij[curnode]) continue;
			for(int[] next : bus[curnode]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				if(dij[nextnode] > curvalue+nextvalue) {
					dij[nextnode] = curvalue+ nextvalue;
					q.add(new int[] {nextnode,dij[nextnode]});
				}
			}
		}
		
		System.out.println(dij[end]);
		StringBuilder sb = new StringBuilder();
		cnt = 1;
		sb.append(start+" ");
		recur(sb,rebus,dij,start,end);
		
		System.out.println(cnt);
		
		System.out.print(sb);
		
	}
	static int cnt;
	static void recur(StringBuilder sb, List<int[]>[] rebus, int[] dij, int start, int curnode) {
		if(curnode==start) return;
		for(int[] next : rebus[curnode]) {
			int nextnode = next[0];
			int nextvalue = next[1];
			if(dij[nextnode] != Integer.MAX_VALUE && dij[curnode] == dij[nextnode] + nextvalue) {
				recur(sb, rebus, dij, start, nextnode);
				sb.append(curnode+" ");
				cnt++;
				return;
			}
		}
	}
}