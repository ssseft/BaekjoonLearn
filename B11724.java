package beakjun;
import java.util.Scanner;

public class B11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] arr = new boolean[n][n];
		boolean[] visited = new boolean[n];
		for(int i =0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a-1][b-1] = true;
			arr[b-1][a-1] = true;
		}
		int count =0;
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				DFS(arr,visited,i,n);
				count++;
			}
		}
		System.out.print(count);
		sc.close();
	}
	
	public static void DFS(boolean[][] arr, boolean[] visited, int a,int n) {
		visited[a] = true;
		for(int i =0; i<n;i++) {
			if(arr[a][i]&&!visited[i]) {
				DFS(arr,visited,i,n);
			}
		}
	}
}