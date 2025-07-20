package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B24042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[n+1];
		long[] ds = new long[n+1];
		Arrays.fill(ds,Long.MAX_VALUE);
		for(int i= 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,i});
			list[to].add(new int[] {from,i});
		}
		PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
		q.add(new long[] {1,0});
		ds[1] = 0;
		
		while(!q.isEmpty()) {
			long[] c = q.poll();
			int curnode = (int)c[0];
			long curcost = c[1];
			if(curcost>ds[curnode]) continue;
			
			for(int[] d : list[curnode]) {
				int nextnode = d[0];
				long nextcost = d[1];
				
				
				if(nextcost<curcost) {
					nextcost += ((curcost-nextcost+m-1)/m)*m;
				}
				
				if(ds[nextnode]>nextcost) {
					ds[nextnode] = nextcost;
					q.add(new long[] {nextnode,ds[nextnode]});
				}
			}
		}
		System.out.println(ds[n]);
	}
}
