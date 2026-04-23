import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		boolean[][] arr=  new boolean[n+1][n+1];
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = true;
			arr[end][start] = true;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a1);
		int[] result= new int[n+1];
		boolean[] visited = new boolean[n+1];
		visited[a1]= true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i =1;i<n+1;i++) {
				if(arr[node][i]&&!visited[i]) {
					visited[i] = true;
					q.add(i);
					result[i] = result[node]+1;
					if(i == a2) {
						System.out.print(result[i]);
						return;
					}
				}
			}
		}
		System.out.print(-1);
	}
}
