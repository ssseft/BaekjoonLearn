import java.io.*;
import java.util.*;

public class Main{
	static boolean[][] visited;
	static char[][] arr;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n,m;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		
		for(int i = 0;i<n;i++) {
			String l = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j);
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<t;i++) {
			int c = n-Integer.parseInt(st.nextToken());
			int y = -1;
			if(i%2==0) {
				for(int j = 0;j<m;j++) {
					if(arr[c][j]=='x') {
						arr[c][j] = '.';
						y = j;
						break;
					}
				}
			}
			else {
				for(int j = m-1;j>=0;j--) {
					if(arr[c][j]=='x') {
						arr[c][j] = '.';
						y = j;
						break;
					}
				}
			}
			
			visited = new boolean[n][m];
			if(y!=-1) {
				for(int d = 0;d<4;d++) {
					int cx = c+dx[d];
					int cy = y+dy[d];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]=='x'&&!visited[cx][cy]&&search(cx,cy)) {
						gravity();
						break;
					};
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static boolean search(int x, int y) {
		boolean end = false;
		list = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		list.add(new int[] {x,y});
		if(x==n-1) end = true;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&arr[cx][cy]=='x') {
					q.add(new int[] {cx,cy});
					visited[cx][cy] = true;
					list.add(new int[] {cx,cy});
					if(cx==n-1) end = true;
				}
			}
		}
		
		return !end;
	}
	static void gravity() {
		int idx = 1;
		boolean pos = true;
		for (int[] c : list) arr[c[0]][c[1]] = '.';
		
		while(true) {
			for(int[] next : list) {
				int x = next[0];
				int y = next[1];
				
				if(x+idx==n||arr[x+idx][y]=='x') {
					pos = false;
					break;
				}
			}
			if(!pos) break;
			idx++;
		}
		idx--;
		for(int[] c : list) {
			int x = c[0];
			int y = c[1];
			arr[x+idx][y] = 'x';
		}
	}
}