import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
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
			list[e].add(new int[] {s,v});
		}
		
		st = new StringTokenizer(br.readLine());

		long[] dij = new long[n+1];
		Arrays.fill(dij, Long.MAX_VALUE);
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
		for(int i = 0;i<k;i++) {
			int c = Integer.parseInt(st.nextToken());
			q.add(new int[] {c,0});
			dij[c] = 0;
		}
		int ansnode = 0;
		long ansvalue = 0;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[1]>dij[c[0]]) continue;
			for(int[] next : list[c[0]]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				if(dij[nextnode]>dij[c[0]]+nextvalue) {
					dij[nextnode] = dij[c[0]]+nextvalue;
					q.add(new int[] {nextnode,nextvalue+c[1]});
				}
			}
		}
		for(int i =1;i<=n;i++) {
			if(ansvalue<dij[i]) {
				ansvalue = dij[i];
				ansnode = i;
			}
		}
		System.out.println(ansnode);
		System.out.print(ansvalue);
	}
}
