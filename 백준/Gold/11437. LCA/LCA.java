import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static int[] level,parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		level = new int[n+1];
		parent = new int[n+1];
		
		list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,0});
		boolean[] visited = new boolean[n+1];
        visited[1] = true;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int node = c[0];
			int dep = c[1];
			for(int next : list[node]) {
				if(!visited[next]) {
					visited[next] = true;
					level[next] = dep+1;
					parent[next] = node;
					q.add(new int[] {next,dep+1});
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a,b)+"\n");
		}
		System.out.print(sb);
		
	}
	public static int lca(int a,int b){
        if(level[a]<level[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        while (level[a] !=level[b])  a = parent[a];
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
