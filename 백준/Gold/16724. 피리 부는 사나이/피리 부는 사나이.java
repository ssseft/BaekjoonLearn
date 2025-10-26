import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[] dir = new char[] {'U','D','L','R'};
	static char[][] arr;
	static int[][] state;
	static int cnt,n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		for(int i = 0;i<n;i++) {
			String l = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j);
			}
		}
		state = new int[n][m];
		
		cnt = 0;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(state[i][j]==0) {
					run(i,j);
				}
			}
		}
		System.out.print(cnt);
	}
	static void run(int x, int y) {
		state[x][y] = 1;
		int d = 0;
		for(int i = 0;i<4;i++) {
			if(arr[x][y]==dir[i]) {
				d = i;
				break;
			}
		}
		int cx = x+dx[d];
		int cy = y+dy[d];
		
		if(cx>=0&&cy>=0&&cx<n&&cy<m) {
			if(state[cx][cy]==0) {
				run(cx,cy);
			}
			else if(state[cx][cy]==1) {
				cnt++;
			}
		}
		state[x][y] = 2;
	}
}