import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[n+1][n+1];
		List<int[]>[][] list = new ArrayList[n+1][n+1];
		
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			list[sx][sy].add(new int[] {ex,ey});
		}
			
		visited[1][1] = true;
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> move = new LinkedList<>();
		q.add(new int[] {1,1});
		
		boolean[][] v;
		boolean[][] pos = new boolean[n+1][n+1];
		pos[1][1] = true;
		
		int cnt = 1;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				for(int[] d : list[c[0]][c[1]]) {
					int x = d[0];
					int y = d[1];
					if(!visited[x][y]) {
						visited[x][y] = true;
						cnt++;
					}
				}
				pos[c[0]][c[1]]= true;
			}
			
			move.add(new int[] {1,1});
			v = new boolean[n+1][n+1];
			v[1][1] = true;
			
			while(!move.isEmpty()) {
				int[] c = move.poll();
				for(int i = 0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=1&&cy>=1&&cx<=n&&cy<=n&&!v[cx][cy]&&visited[cx][cy]) {
						v[cx][cy] = true;
						move.add(new int[] {cx,cy});
						if(!pos[cx][cy]) {
							q.add(new int[] {cx,cy});
						}
					}
				}
			}
		}
		
		System.out.print(cnt);
	}
}
