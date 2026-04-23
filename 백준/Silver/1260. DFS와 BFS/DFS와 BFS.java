import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		boolean[] visited = new boolean[n+1];
		int[][] graph = new int[n+1][n+1];
		for(int i = 0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		sc.close();
		
		
		dfs(v, visited, graph, n);
		System.out.println();
		for(int i = 0; i<n+1; i++) {
			visited[i] = false;
		}
		bfs(v, visited, graph, n);
		
		
		
	}
	public static void dfs(int a,boolean[] visited, int[][] graph,int n) {
		visited[a] = true;
		System.out.print(a + " ");
		for (int i = 1; i <= n; i++) {
		    if (graph[a][i] == 1 && !visited[i]) {
		        dfs(i, visited, graph, n);
		    }
		}
	}
	
	public static void bfs(int start, boolean[] visited, int[][] graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
