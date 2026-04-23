import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n+1][m+1];
		
		for(int i = 1;i<=n;i++) {
			String line = br.readLine();
			for(int j =0;j<m;j++) {
				arr[i][j+1] = line.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int startx = Integer.parseInt(st.nextToken());
		int starty = Integer.parseInt(st.nextToken());
		int endx = Integer.parseInt(st.nextToken());
		int endy = Integer.parseInt(st.nextToken());
		
		int[][] visited = new int[n+1][m+1];
		for(int i = 1;i<=n;i++) Arrays.fill(visited[i], -1);
		Queue<int[]> q = new LinkedList<>();
		visited[startx][starty] = 0;
		q.add(new int[] {startx,starty});
		int time = 0;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				int x = c[0];
				int y = c[1];
				if(x==endx&&y==endy) {
					System.out.print(time);
					return;
				}
				for(int j = 0;j<4;j++) {
					for(int k = 1;k<=r;k++) {
						int cx = x+dx[j]*k;
						int cy = y+dy[j]*k;
						if(cx>=1&&cy>=1&&cx<=n&&cy<=m) {
							if(arr[cx][cy]=='#') break;
							
							if(visited[cx][cy]!=-1) {
								if(visited[cx][cy]<time+1) break;
								else continue;
							}
							
							visited[cx][cy] = time+1;
							q.add(new int[] {cx,cy});
							
						}
					}
				}
			}
			time++;
		}
		System.out.println(-1);
	}
}
