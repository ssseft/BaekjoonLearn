package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B1520 {	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int m;
	static int[][] dp;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		dp = new int[n][m];
		for(int i =0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.print(DFS(0,0));
	}
	public static int DFS(int x, int y) {
		if(x==n-1&&y==m-1) {
			return 1;
		}
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]<arr[x][y]) {
				dp[x][y] += DFS(cx,cy);
			}
		}
		return dp[x][y];
	}
}
