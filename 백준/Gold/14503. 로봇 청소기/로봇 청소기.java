import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean visited[][];
	static int n;
	static int m;
	static int direction;
	static int[] dx = {-1,0,1,0}; // 서 남 동 북
	static int[] dy = {0,1,0,-1};
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][m];
		count = 0;
		search(r,c,direction);
		
		
		System.out.print(count);
		
		
		
		
	}
	public static void search(int x, int y,int direction) {//북 0 동 1 남 2 서 3
		if(!visited[x][y]) {
			visited[x][y] = true;
			count++;
		}
		boolean check = false;
		for(int i = 0; i<4;i++) {
			int new_direction = (direction+3-i+4) % 4;
			int cx = x+dx[new_direction];
			int cy = y+dy[new_direction];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&arr[cx][cy]==0) {
				search(cx,cy,new_direction);
				check = true;
				break;
			}
		}
		int back_x = x+dx[(direction+2)%4];
		int back_y = y+dy[(direction+2)%4];
		if(!check) {
			if(back_x>=0&&back_y>=0&&back_x<n&&back_y<m&&arr[back_x][back_y]==0) {
				search(back_x,back_y,direction);
			}
			else {
				return;
			}
		}
	}
}
