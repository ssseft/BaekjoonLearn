import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node; 
                    queue.add(neighbor);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
	}
}
