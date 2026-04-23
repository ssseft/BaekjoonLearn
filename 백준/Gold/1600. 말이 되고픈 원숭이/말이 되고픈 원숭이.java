import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int[] hmvx = {-2,-2,-1,1,2,2,1,-1};
		int[] hmvy = {-1,1,2,2,1,-1,-2,-2};
		
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[n][m][k+1];
		visited[0][0][0] = true;
		q.add(new int[] {0,0,0});
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int a = 0;a<size;a++) {
				int[] c = q.poll();
				if(c[0]==n-1&&c[1]==m-1) {
					System.out.print(time);
					return;
				}
				if(c[2]<k) {
					for(int i = 0;i<8;i++) {
						int cx = c[0]+hmvx[i];
						int cy = c[1]+hmvy[i];
						if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy][c[2]+1]&&arr[cx][cy]!=1) {
							visited[cx][cy][c[2]+1] = true;
							q.add(new int[] {cx,cy,c[2]+1});
						}
					}
				}
				for(int i = 0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy][c[2]]&&arr[cx][cy]!=1) {
						visited[cx][cy][c[2]] = true;
						q.add(new int[] {cx,cy,c[2]});
					}
				}
			}
			time++;
		}
		System.out.print(-1);
		
	}
}
