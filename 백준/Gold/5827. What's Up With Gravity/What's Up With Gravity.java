import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		char[][] arr = new char[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		
		int[] gx = {1,-1};
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int[][][] visited = new int[n][m][2];
		int goalx = 0;
		int goaly = 0;
		
		for(int i = 0;i<n;i++) {
			String l = sc.nextLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j);
				visited[i][j][0] = 99999;
				visited[i][j][1] = 99999;
				
				if(arr[i][j]=='C') {
					q.add(new int[] {i,j,0,0});
					arr[i][j] = '.';
					visited[i][j][0] = 0;
				}
				
				else if(arr[i][j]=='D') {
					goalx = i;
					goaly = j;
				}
			}
		}
		//아래가
		// '#'이면 왼쪽, 오른쪽으로 이동하거나 중력 위치 변경
		// '.'이면 그쪽으로 이동
		// 중력방향 0 = 아래 1 = 위
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0]+gx[c[2]];
			int y = c[1];
			int cnt = c[3];
			
			if(x<0||x>=n||visited[x][y][c[2]]<=cnt) continue;
			
			if(arr[x][y]=='.') {
				visited[x][y][c[2]] = cnt;
				q.add(new int[] {x,y,c[2],cnt});
			}
			else if(arr[x][y]=='#') {
				int d = (c[2]+1)%2;
				x -= gx[c[2]];
				if(visited[x][y][d]>cnt+1) {
					visited[x][y][d] = cnt+1;
					q.add(new int[] {x,y,d,cnt+1});
				}
				
				for(int i = 2;i<4;i++) {
					int cx = x+dx[i];
					int cy = y+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&visited[cx][cy][c[2]]>cnt) {
						if(arr[cx][cy]=='.') {
							visited[cx][cy][c[2]] = cnt;
							q.add(new int[] {cx,cy,c[2],cnt});
						}
						else if(arr[cx][cy]=='D') {
							visited[cx][cy][c[2]] = Math.min(visited[cx][cy][c[2]], cnt);
						}
					}
				}
			}
			else {
				visited[x][y][c[2]] = Math.min(visited[x][y][c[2]], cnt);
			}
		}
		int ans = Math.min(visited[goalx][goaly][0], visited[goalx][goaly][1]);
		if(ans==99999) System.out.print(-1);
		else System.out.print(ans);
	}
}
