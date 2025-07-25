package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6593 {
	static int[] dx = {0,0,0,0,1,-1};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {1,-1,0,0,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L==0) break;
			boolean[][][] visited = new boolean[L][R][C];
			Queue<int[]> q = new LinkedList<>();
			
			
			char[][][] field = new char[L][R][C];
			
			for(int i = 0;i<L;i++) {
				for(int j = 0;j<R;j++) {
					String line = br.readLine();
					for(int k = 0;k<C;k++) {
						field[i][j][k] = line.charAt(k);
						if(field[i][j][k]=='S') {
							q.add(new int[] {i,j,k});
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			int time = 0;
			boolean search = false;
			while(!q.isEmpty()) {
				int size = q.size();
				int cnt = 0;
				
				for(int i = 0;i<size;i++) {
					int[] c = q.poll();
					for(int j = 0;j<6;j++) {
						int cz = c[0]+dz[j];
						int cx = c[1]+dx[j];
						int cy = c[2]+dy[j];
						if(cz>=0&&cx>=0&&cy>=0&&cz<L&&cx<R&&cy<C&&!visited[cz][cx][cy]) {
							
							if(field[cz][cx][cy]=='.') {
								q.add(new int[] {cz,cx,cy});
								visited[cz][cx][cy] = true;
								cnt++;
							}
							if(field[cz][cx][cy]=='E') {
								search = true;
								cnt++;
								break;
							}
						}
					}
					if(search) break;
				}
				if(cnt!=0) time++;
				if(search) break;
			}
			if(search) {
				sb.append("Escaped in "+time+" minute(s).\n");
			}
			else {
				sb.append("Trapped!\n");
			}
		}
		System.out.print(sb.toString().trim());
	}
}
