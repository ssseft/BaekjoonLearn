import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		boolean[][][] visited = new boolean[n][m][64];
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0;i<n;i++) {
			String l = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j);
				if(arr[i][j]=='0') {
					q.add(new int[] {i,j,0});
					visited[i][j][0] = true;
				}
			}
		}
		
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				for(int j = 0;j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m) {
						char w = arr[cx][cy];
						if(w=='#'||visited[cx][cy][c[2]]) continue;
						else if(w=='.'||arr[cx][cy]=='0') {
							q.add(new int[] {cx,cy,c[2]});
							visited[cx][cy][c[2]]=true;
						}
						else if(w=='1') {
							System.out.print(time);
							return;
						}
						else if(w>='a'&&w<='f') {
							int bit = c[2]|(1<<(w-'a'));
							if(!visited[cx][cy][bit]) {
								visited[cx][cy][bit] = true;
								q.add(new int[] {cx,cy,bit});
							}
						}
						if(w>='A'&&w<='F') {
							if((c[2]&(1<<(w-'A')))!=0) {
								q.add(new int[] {cx,cy,c[2]});
								visited[cx][cy][c[2]]=true;
							}
						}
					}
				}
			}
			time++;
		}
		System.out.print(-1);
	}
}
