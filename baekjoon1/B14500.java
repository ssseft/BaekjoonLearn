package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B14500 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int max;
	static int[][] arr;
	static int n;
	static int m;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		visited = new boolean[n][m];
		for(int i = 0; i<n;i++) {
			for(int j =0; j<m;j++) {
				BFS(i,j,0,0);
			}
		}
		int sum;
		for(int i = 0; i<n-2;i++) {
			for(int j =0; j<m;j++) {
				sum = 0;
				sum += arr[i][j]+arr[i+1][j]+arr[i+2][j];
				if(j==0) {
					sum += arr[i+1][j+1];
				}
				else if(j==m-1){
					sum+= arr[i+1][j-1];
				}
				else {
					sum+= Math.max(arr[i+1][j-1], arr[i+1][j+1]);
				}
				max = Math.max(sum, max);
			}
		}
		for(int i =0; i<n;i++) {
			for(int j = 0;j<m-2;j++) {
				sum=0;
				sum+=arr[i][j]+arr[i][j+1]+arr[i][j+2];
				if(i==0) {
					sum+=arr[i+1][j+1];
				}
				else if(i==n-1) {
					sum+=arr[i-1][j];
				}
				else {
					sum+=Math.max(arr[i+1][j+1],arr[i-1][j+1]);
				}
				max = Math.max(sum, max);
			}
		}
		System.out.print(max);
	}
	public static void BFS(int x, int y,int size,int sum) {
		if(size==4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]) {
				visited[cx][cy] = true;
				BFS(cx,cy,size+1,sum+arr[cx][cy]);
				visited[cx][cy] = false;
			}
		}
	}
}
