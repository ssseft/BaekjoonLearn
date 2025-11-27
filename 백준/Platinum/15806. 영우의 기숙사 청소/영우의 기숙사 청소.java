import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new ArrayDeque<>();
		int[][][] MinTime = new int[n+1][n+1][2];
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				for(int s =0;s<2;s++) {
					MinTime[i][j][s] = 111111;
				}
			}
		}
		
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new int[] {x,y,0});
		}
		
		int[] dx = {-1,-2,-2,-1,1,2,2,1};
		int[] dy = {-2,-1,1,2,2,1,-1,-2};
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int time = c[2];
			for(int i = 0;i<8;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>0&&cy>0&&cx<=n&&cy<=n&&MinTime[cx][cy][(time+1)%2]==111111) {
					MinTime[cx][cy][(time+1)%2] = time+1;
					q.add(new int[] {cx,cy,time+1});
				}
			}
		}
		
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(MinTime[x][y][t%2]<=t) {
				System.out.print("YES");
				return;
			}
		} 
		System.out.print("NO");
	}
}