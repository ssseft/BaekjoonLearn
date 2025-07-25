package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3197 {
	static int x, y;
	static char[][] arr;
	static int[] start,end;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	static Queue<int[]> q;
	static Queue<int[]> water;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		arr = new char[x][y];
		visited = new boolean[x][y];
		
		q = new LinkedList<>();
		water = new LinkedList<>();
		start = new int[2];
		end = new int[2];
		start[0] = -1;
		start[1] = -1;
		for(int i = 0; i<x;i++) {
			String line = br.readLine();
			for(int j = 0; j<y;j++) {
				arr[i][j] = line.charAt(j);
				if(arr[i][j]=='L') {
					if(start[0] ==-1) {
						start[0] = i;
						start[1] = j;
						q.add(new int[] {i,j});
					}
					else {
						end[0] = i;
						end[1] = j;
					}
					water.add(new int[] {i,j});
				}
				else if(arr[i][j] == '.') {
					water.add(new int[] {i,j});
				}
			}
		}
		visited[start[0]][start[1]] = true;
		
		int day = 0;
		
		while(!check()) {
			Queue<int[]> water2 = new LinkedList<>();
			while(!water.isEmpty()) {
				int[] c = water.poll();
				
				for(int i = 0;i <4;i++) {
					int nx = c[0]+dx[i];
					int ny = c[1]+dy[i];
					
					if (nx<0||nx>=x||ny<0||ny>=y||arr[nx][ny]=='.'|| visited[nx][ny]) {
					    continue;
					}
					
					arr[nx][ny] = '.';
					water2.add(new int[] {nx,ny});
					
				}
			}
			water = water2;
			
			day++;
			
		}
		
		System.out.print(day);
		
	}
	static boolean check() {
		Queue<int[]> q2 = new LinkedList<>();
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size> 0) {
				int[] current = q.poll();
				int cx = current[0];
				int cy = current[1];
				
				if(cx==end[0]&&cy==end[1]) {
					return true;
				}
				
				for(int i = 0; i<4;i++) {
					
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					
					if (nx < 0 || nx >= x || ny < 0 || ny >= y || visited[nx][ny]) {
					    continue;
					}

					
					visited[nx][ny] = true;
					
					if(arr[nx][ny]=='X') {
						q2.add(new int[] {nx,ny});
					}
					else {
						q.add(new int[] {nx,ny});
					}
				}
				size--;
			}
		}
		q = q2;
		return false;
	}
}
