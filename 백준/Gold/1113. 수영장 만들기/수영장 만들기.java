import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[n][m];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0;i<n;i++) {
			String l = sc.nextLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j)-'0';
				if(i==0||j==0||i==n-1||j==m-1) {
					q.add(new int[] {i,j,arr[i][j]});
					visited[i][j] = true;
				}
			}
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int ans = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			for(int i = 0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]) {
					if(arr[cx][cy]<=c[2]) {
						visited[cx][cy] = true;
						ans += c[2]-arr[cx][cy];
						q.add(new int[] {cx,cy,Math.max(c[2], arr[cx][cy])});
					}
					else {
						visited[cx][cy] = true;
						q.add(new int[] {cx,cy,Math.max(c[2], arr[cx][cy])});
					}
				}
			}
		}
		
		System.out.print(ans);
	}
}