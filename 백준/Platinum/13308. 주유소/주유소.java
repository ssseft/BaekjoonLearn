import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<long[]>[] list = new ArrayList[n+1];
		int[] oil = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1;i<=n;i++) {
			oil[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new long[] {e,v});
			list[e].add(new long[] {s,v});
		}
		
		
		PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

		
		q.add(new long[] {1,0,oil[1]});
		long[][] minoil = new long[n+1][2501];
		for(int i = 1;i<=n;i++) {
			Arrays.fill(minoil[i], Long.MAX_VALUE);
		}
		
		long result = 0;
		
		
		while(!q.isEmpty()) {
			long[] c = q.poll();
			long curnode = c[0];
			long curvalue = c[1];
			if(curnode==n) {
				result = curvalue;
				break;
			}
			for(long[] next : list[(int)curnode]) {
				long nextnode = next[0];
				long nextvalue = next[1];
				if(minoil[(int)nextnode][(int)c[2]]>curvalue+nextvalue*c[2]) {
					minoil[(int)nextnode][(int)c[2]] = curvalue+nextvalue*c[2];
					q.add(new long[] {nextnode,minoil[(int)nextnode][(int)c[2]],Math.min(c[2], oil[(int)nextnode])});
				}
			}
		}
		
		System.out.print(result);
	}
}
