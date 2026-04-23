import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static int n;
	static int max;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		int maxnum = 0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j <n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>maxnum){
					maxnum=arr[i][j];
				}
			}
		}
		int result = 0;
		for(int i = 1; i<=maxnum;i++) {
			visited = new boolean[n][n];
			max = 0;
			for(int j = 0; j<n;j++) {
				for(int k=0; k<n;k++) {
					if(arr[j][k]>i&&!visited[j][k]) {
						BFS(j,k,i);
						max++;
					}
				}
			}
			result = Math.max(max, result);
		}
		if(result ==0) {
			System.out.print(result+1);
		}
		else {
			System.out.print(result);
		}
		
		
		
	}
	public static void BFS(int x, int y,int depth) {
		visited[x][y] = true;
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<n&&arr[cx][cy]>depth&&!visited[cx][cy]) {
				BFS(cx,cy,depth);
			}
		}
	}
}