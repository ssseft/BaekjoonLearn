import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int n,min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[n];
		min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			visited[i] = true;
			recur(0,0,i,i);
			visited[i] = false;
		}
		
		System.out.print(min);
	}
	static void recur(int cnt, int value,int cur,int start) {
		if(cnt==n-1) {
            if(arr[cur][start]==0) return;
			min = Math.min(min, value+arr[cur][start]);
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(!visited[i]) {
				if(arr[cur][i]==0) return;
				visited[i] = true;
				value+= arr[cur][i];
				recur(cnt+1,value,i,start);
				visited[i] = false;
				value-= arr[cur][i];
			}
		}
	}
}