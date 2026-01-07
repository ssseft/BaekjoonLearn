import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		for(int i = 0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(arr[i][j]=='J') q.add(new int[] {i,j});
				if(arr[i][j]=='F') q2.add(new int[] {i,j});
			}
		}
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int cnt = 1;
		while(!q.isEmpty()) {
			int jsize = q.size();
			for(int i = 0;i<jsize;i++) {
				int[] c = q.poll();
				for(int j = 0;j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if((c[0]==0||c[1]==0||c[0]==n-1||c[1]==m-1)&&arr[c[0]][c[1]]=='J') {
						System.out.print(cnt);
						return;
					}
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]=='.') {
						arr[cx][cy] = 'J';
						q.add(new int[] {cx,cy});
					}
				}
			}
			
			int fsize = q2.size();
			for(int i = 0;i<fsize;i++) {
				int[] c = q2.poll();
				for(int j = 0;j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&(arr[cx][cy]=='.'||arr[cx][cy]=='J')) {
						arr[cx][cy] = 'F';
						q2.add(new int[] {cx,cy});
					}
				}
			}
			cnt++;
		}
		
		
		
		System.out.print("IMPOSSIBLE");
	}
}
