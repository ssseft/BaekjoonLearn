import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int n;
	static int m;
	static int h;
	static int[][][] arr;
	static boolean[][][] visited;
	static Queue<int[]> q;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//가로
		m = Integer.parseInt(st.nextToken());//세로
		h = Integer.parseInt(st.nextToken());//높이
		arr = new int[m][n][h];
		
		for(int i = 0; i<h;i++) {
			for(int j =0;j<m;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++) {
					 arr[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		//-1 토마토가 없음
		//0 안익은 토마토
		//1 익은토마토 
		visited = new boolean[m][n][h];
		q = new LinkedList<>();
		for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k][i] == 1) {
                        q.add(new int[]{j, k, i});
                        visited[j][k][i] = true;
                    }
                }
            }
        }
        BFS();
        
		int max = 0;
		for(int i = 0; i<h;i++) {
			for(int j =0;j<m;j++) {
				for(int k=0;k<n;k++) {
					if(arr[j][k][i]== 0) {
						System.out.print(-1);
						return;
					}
					if(arr[j][k][i]>max) {
						max = arr[j][k][i];
					}
				}
			}
		}
		System.out.print(max-1);
		
	}
	static void BFS() {
		while(!q.isEmpty()) {
			int[] xyz = q.poll();
			int cx = xyz[0];
			int cy = xyz[1];
			int cz = xyz[2];
			for(int i =0;i<6;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				int nz = cz+dz[i];
				if(nx>=0&&ny>=0&&nz>=0&&nx<m&&ny<n&&nz<h&&!visited[nx][ny][nz]) {
					if(arr[nx][ny][nz]==-1) {
						visited[nx][ny][nz] = true;
					}
					else if(arr[nx][ny][nz]==0) {
						q.add(new int[] {nx,ny,nz});
						visited[nx][ny][nz] = true;
						arr[nx][ny][nz] = arr[cx][cy][cz]+1;
					}
				}
			}
		}
	}
}
