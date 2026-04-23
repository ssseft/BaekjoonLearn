import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static int[][] parent;
	static int[] level;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		h = (int) Math.ceil(Math.log(n)/Math.log(2));
		
		level = new int[n+1];
		
		parent = new int[h+1][n+1];
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
					parent[0][next] = node;
					q.add(new int[] {next,dep+1});
				}
			}
		}
		
		parent[0][1] = 1; //마지막 1이 공통조상일 때, parent[0][a]방지
		for(int i = 1;i<=h;i++){
			for(int j = 1;j<=n;j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
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
        
        String bit = Integer.toBinaryString(level[a]-level[b]);
        
        for(int i = 0;i<bit.length();i++){
            if(bit.charAt(bit.length()-1-i)=='1'){
            	a=parent[i][a];
            }
        }
        
        if(a==b) return a;
        
        for(int i = h;i>=0;i--) {
        	if(parent[i][a]!=parent[i][b]) {
        		a = parent[i][a];
        		b = parent[i][b];
        	}
        }
        
        return parent[0][a];
    }
}