import java.util.*;

public class Main {
	static int n,m;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new char[n][m];
		for(int i = 0;i<n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		int max=  0;
		
		for(int i = 0;i<n;i++) {
			for(int j=  0;j<m;j++) {
				if(arr[i][j]=='L') {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.println(max);
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int bfs(int x,int y) {
		int cnt = -1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int size=  q.size();
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				for(int j = 0;j<4;j++) {
					int cx=  c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&arr[cx][cy]=='L') {
						q.add(new int[] {cx,cy});
						visited[cx][cy] = true;
					}
				}
			}
			cnt++;
		}
		return cnt;
	}
}
