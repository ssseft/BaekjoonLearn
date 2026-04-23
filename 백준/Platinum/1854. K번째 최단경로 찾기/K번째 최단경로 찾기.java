import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<int[]>[] graph = new ArrayList[n+1];
		PriorityQueue<Integer>[] list = new PriorityQueue[n+1];
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<>();
			list[i] = new PriorityQueue<>((a,b)->b-a);
		}
		list[1].add(0);
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e,v});
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
		q.add(new int[] {1,0});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curvalue = c[1];
			if(list[curnode].size()==k&&list[curnode].peek()<curvalue) continue;
			for(int[] next : graph[curnode]) {
				int nextnode = next[0];
				int nextvalue = curvalue+next[1];
				if(list[nextnode].size()==k) {
					if(list[nextnode].peek()>nextvalue) {
						list[nextnode].poll();
						list[nextnode].add(nextvalue);
                        q.add(new int[] {nextnode,nextvalue});
					}
				}
				else {
					list[nextnode].add(nextvalue);
                    q.add(new int[] {nextnode,nextvalue});
				}
			}
		}
		
		
		for(int i = 1;i<=n;i++) {
			if(list[i].size()<k) {
				sb.append(-1);
			}
			else {
				sb.append(list[i].poll());
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
