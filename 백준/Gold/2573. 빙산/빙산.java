import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0;i <n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		
		while(true) {
			int cnt = 0;
			visited = new boolean[n][m];
			int[][] new_arr = new int[n][m];
			
			boolean check = true;
			for(int i =1;i<n-1;i++) {
				for(int j =1;j<m-1;j++) {
					new_arr[i][j] = arr[i][j];
					if(arr[i][j] !=0) {
						check = false;
					}
				}
			}
			if(check) {
				System.out.print(0);
				return;
			}
			
			for(int i = 1; i<n-1;i++) {
				for(int j = 1; j<m-1;j++) {
					if(arr[i][j]!=0) {
						cal(i,j,new_arr);
					}
				}
			}
			year++;
			for(int i = 1; i<n-1;i++) {
				for(int j =1; j<m-1;j++) {
					if(new_arr[i][j]!=0&&!visited[i][j]) {
						cnt++;
						DFS(i,j,new_arr);
					}
				}
			}
			if(cnt>1) {
				break;
			}
			arr = new_arr;
		}
		System.out.print(year);
		
		
	}
	public static void cal(int x, int y,int[][] new_arr) {
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int count = 0;
		
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(arr[cx][cy]==0) {
				count++;
			}
		}
		if(arr[x][y]-count<=0) {
			new_arr[x][y] = 0;
		}
		else {
			new_arr[x][y] = arr[x][y] - count;
		}
	}
	public static void DFS(int x, int y,int[][] new_arr) {
		visited[x][y] = true;
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(new_arr[cx][cy]!=0&&!visited[cx][cy]) {
				DFS(cx,cy,new_arr);
			}
		}
		
	}
}