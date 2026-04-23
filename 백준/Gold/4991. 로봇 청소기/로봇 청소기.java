import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0&&m==0) break;
			
			Queue<int[]> q = new LinkedList<>();
			char[][] arr = new char[n][m];
			int idx = 1;
			int sx = 0;
			int sy = 0;
			for(int i = 0;i<n;i++) {
				String l = br.readLine();
				for(int j = 0;j<m;j++) {
					arr[i][j] = l.charAt(j);
					if(arr[i][j]=='*') arr[i][j] = (char)('0'+idx++);
					else if(arr[i][j]=='o') {
						q.add(new int[] {i,j,0});
						arr[i][j] = '.';
						sx = i;
						sy = j;
					}
				}
			}
			
			boolean[][][] visited = new boolean[n][m][1<<idx];
			visited[sx][sy][0] = true;
			int time = 0;
			boolean ch = false;
			
			while(!q.isEmpty()&&!ch) {
				int size = q.size();
				
				for(int i = 0;i<size;i++) {
					int[] c = q.poll();
					for(int j = 0;j<4;j++) {
						int cx = c[0]+dx[j];
						int cy = c[1]+dy[j];
						if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy][c[2]]&&arr[cx][cy]!='x') {
							if(arr[cx][cy]>'0'&&arr[cx][cy]<'0'+idx) {
								int bit = c[2]|(1<<(arr[cx][cy]-'0'));
								if(!visited[cx][cy][bit]) {
									visited[cx][cy][bit] = true;
									q.add(new int[] {cx,cy,bit});
								}
                                //idx가 1부터시작이라 2뺌
								if(bit==(1<<idx)-2) ch = true;
							}
							else {
								visited[cx][cy][c[2]] = true;
								q.add(new int[] {cx,cy,c[2]});
							}
						}
					}
				}
				time++;
			}
			if(!ch) sb.append(-1+"\n");
			else sb.append(time+"\n");
		}
		System.out.println(sb);
		
		
	}
}
