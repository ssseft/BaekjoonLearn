import java.io.*;
import java.util.*;

public class Main {
	static int h;
	static int[] level;
	static int[][][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		h = (int) Math.ceil(Math.log(n)/Math.log(2));
		
		level = new int[n+1];
		arr = new int[h+1][n+1][2];
		
		List<int[]>[] list = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<n-1;i++) {
			st =  new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[s].add(new int[] {e,v});
			list[e].add(new int[] {s,v});
		}
		
		
		boolean[] visited = new boolean[n+1];
		Queue<int[]> q = new ArrayDeque<>();
		visited[1] = true;
		
		q.add(new int[] {1,0});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int node = c[0];
			int dep = c[1];
			for(int[] next : list[node]) {
				if(!visited[next[0]]) {
					level[next[0]] = dep+1;
					visited[next[0]] = true;
					arr[0][next[0]][0] = node;
					arr[0][next[0]][1] = next[1];
					q.add(new int[] {next[0],dep+1});
				}
			}
		}
		
		arr[0][1][0] = 1;
		for(int i = 1;i<=h;i++){
			for(int j = 1;j<=n;j++) {
				int[] before = arr[i-1][arr[i-1][j][0]];
				arr[i][j][0] = before[0];
				arr[i][j][1] = before[1] + arr[i-1][j][1];
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(cal(a,b)+"\n");
		}
		System.out.print(sb);	
	}
	static int cal(int a, int b) {
		int total = 0;
		if(level[a]<level[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int dif = level[a]-level[b];
		for(int i = 0;i<=h;i++) {
			if(((1<<i)&dif)!=0) {
				total += arr[i][a][1];
				a = arr[i][a][0];
			}
		}
		
		if(a==b) return total;
		
        for(int i = h;i>=0;i--){
        	if(arr[i][a][0]!=arr[i][b][0]) {
        		total += (arr[i][a][1] + arr[i][b][1]);
        		a = arr[i][a][0];
        		b = arr[i][b][0];
        	}
        }
        total += arr[0][a][1] + arr[0][b][1];
		return total;
	}
}