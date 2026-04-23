import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[][] num;
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n][m];
		sc.nextLine();
		for(int i = 0;i <n;i++) {
			String nums = sc.nextLine();
			for(int j=0;j<m;j++) {
				num[i][j] = nums.charAt(j) - '0';
			}
		}
		bfs();
		System.out.print(num[n-1][m-1]);
		
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0});
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0;i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && num[nx][ny] == 1) {
					num[nx][ny] = num[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
			}
		}
	}
}