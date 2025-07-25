package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] field = new char[n][m];
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[n][m][(1<<7)+1];
		
		for(int i = 0;i<n;i++) {
			String line = br.readLine();
			for(int j = 0;j<m;j++) {
				field[i][j] = line.charAt(j);
				if(field[i][j]=='0') {
					q.add(new int[] {i,j,0});
					visited[i][j][0] = true;
				}
			}
		}
		
		
		int cnt = 1;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				int x = c[0];
				int y = c[1];
				int bit = c[2];
				
				
				for(int j = 0;j<4;j++) {
					int cx = x+dx[j];
					int cy = y+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&field[cx][cy]!='#'&&!visited[cx][cy][bit]){
						if(field[cx][cy]=='.'||field[cx][cy]=='0') {
							visited[cx][cy][bit] = true;
							q.add(new int[] {cx,cy,bit});
						}
						else if(field[cx][cy]>=97&&field[cx][cy]<=102) {
							int nextbit = (bit|(1<<(field[cx][cy]-'a')));
							if(!visited[cx][cy][nextbit]) {
								q.add(new int[] {cx,cy,nextbit});
								visited[cx][cy][nextbit] = true;
							}
						}
						else if(field[cx][cy]>=65&&field[cx][cy]<=70) {
							if((bit&(1<<(field[cx][cy]-'A')))!=0) {
								visited[cx][cy][bit] = true;
								q.add(new int[] {cx,cy,bit});
							}
						}
						else if(field[cx][cy]=='1') {
							System.out.println(cnt);
							return;
						}
					}
				}
			}
			cnt++;
		}
		//a = 97 (아스키) A = 65
		
		System.out.println(-1);	
	}
}
