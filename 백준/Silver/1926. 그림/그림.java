import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int max;
	static int n;
	static int m;
	static int count;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//1이면 그림 0이면 빈칸 대각선은 x
		visited = new boolean[n][m];
		max = 0;
		count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
			}
		}
		System.out.print(count+"\n"+max);
		
		
		
		
	}
	static void BFS(int x,int y) {
		q.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];

            for (int i=0; i<4;i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==1 &&!visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        max = Math.max(max, size);
        count++;
	}
}
