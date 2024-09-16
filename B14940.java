package beakjun;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static int n;
	static int m;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int x = 0;
		int y = 0;
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					x= i;
					y =j;
				}
			}
		}
		arr[x][y]= 0;
		visited = new boolean[n][m];
		BFS(x,y);
		for (int i =0;i<n;i++) {
            for (int j=0; j<m;j++) {
                if (arr[i][j]!=0&&!visited[i][j]) {
                    arr[i][j]=-1;
                }
            }
        }

		for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
		bw.flush();
        bw.close();
		
		
	}
	static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cx = current[0];
			int cy = current[1];
			
			for(int i =0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m&&!visited[nx][ny]&&arr[nx][ny]!=0) {
					visited[nx][ny] = true;
					arr[nx][ny] = arr[cx][cy]+1;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
}
