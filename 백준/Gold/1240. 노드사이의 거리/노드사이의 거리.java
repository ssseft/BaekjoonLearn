import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<int[]>[] list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) list[i] = new ArrayList<>();
		for(int i =0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
		}
		Queue<int[]> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<m;i++) {
			q.clear();
			boolean[] visited = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			visited[s] = true;
			q.add(new int[] {s,0});
			int value = 0;
			while(!q.isEmpty()) {
				int[] c = q.poll();
				if(c[0]==e) {
					value = c[1];
					break;
				}
				for(int[] node : list[c[0]]) {
					if(!visited[node[0]]) {
						visited[node[0]] = true;
						q.add(new int[] {node[0],node[1]+c[1]});
					}
				}
			}
			sb.append(value+"\n");
		}
		System.out.print(sb);
	}
}
