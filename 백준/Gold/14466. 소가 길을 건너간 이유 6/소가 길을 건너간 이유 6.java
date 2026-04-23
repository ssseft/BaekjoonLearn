import java.io.*;
import java.util.*;

public class Main {
	static int idx,n,k;
	static int[][] arr;
	static boolean[][][] road;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		road = new boolean[n+1][n+1][4];
		//상 하 좌 우에 길이 있나
		
		for(int i = 0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if(x1+1==x2) {
				road[x1][y1][1] = true;
				road[x2][y2][0] = true;
			}
			else if(x1-1==x2) {
				road[x1][y1][0] = true;
				road[x2][y2][1] = true;
			}
			else if(y1+1==y2) {
				road[x1][y1][3] = true;
				road[x2][y2][2] = true;
			}
			else {
				road[x1][y1][2] = true;
				road[x2][y2][3] = true;
			}
		}
		
		idx = 1;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				if(arr[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		int cnt = 0;
		List<int[]> cow = new ArrayList<>();
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cow.add(new int[] {x,y});
		}
		
		for(int i = 0;i<cow.size();i++) {
			int[] c = cow.get(i);
			for(int j = i+1;j<cow.size();j++ ) {
				int[] next = cow.get(j);
				if(c==next) continue;
				if(arr[c[0]][c[1]]!=arr[next[0]][next[1]]) cnt++;
			}
		}
		
		System.out.print(cnt);
	}
	static void bfs(int x,int y) {
		arr[x][y] = idx;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>0&&cy>0&&cx<=n&&cy<=n&&arr[cx][cy]==0&&!road[c[0]][c[1]][i]) {
					arr[cx][cy] = idx;
					q.add(new int[] {cx,cy});
				}
			}
		}
		
		idx++;
	}
}