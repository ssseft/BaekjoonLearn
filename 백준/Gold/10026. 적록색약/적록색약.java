import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		arr = new int[n][n];
		for(int i =0; i<n; i++) {
			String a = sc.next();
			for(int j =0; j<n; j++) {
				if(a.charAt(j)=='R') { //빨강 0 초록 1 파랑 2 즉 적록색약은 0==1
					arr[i][j]=0;
				}
				else if(a.charAt(j)=='G') {
					arr[i][j]=1;
				}
				else {
					arr[i][j] = 2;
				}
			}
		}
		int count = 0;
		int count2 = 0;
		visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n;j++) {
                if (!visited[i][j]) {
                    bfs(i,j,arr[i][j]);
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) { //0==1로 바꿈
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) arr[i][j] = 0; 
            }
        }
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n;j++) {
                if (!visited[i][j]) {
                    bfs(i,j,arr[i][j]);
                    count2++;
                }
            }
        }
		System.out.print(count+" "+count2);
		
		
	}
	
	public static void bfs(int x, int y, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && arr[nx][ny] == color) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}