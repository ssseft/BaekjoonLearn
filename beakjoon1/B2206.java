package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
	static int n,m;
	static int[][] arr;
	static Queue<int[]> q;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int cnt;
	static boolean[][][] visited;
	static boolean search;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		q = new LinkedList<>();
		visited = new boolean[n][m][2];
		cnt = 0;
		search = false;
		q.add(new int[] {0,0,0});
		visited[0][0][0] = true;
		
		for(int i = 0; i<n;i++) {
			String line = br.readLine();
			for(int j = 0; j<m;j++) {
				arr[i][j] = line.charAt(j)-48;
			}
		}
		while(!search) {
			BFS();
			cnt++;
			
			if(!search&&q.isEmpty()) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(cnt);
	}
	public static void BFS() {
		Queue<int[]> q2 = new LinkedList<>();
		// x, y ,0or1(벽 뚫었는지 여부)
		int size = q.size();
		for(int i = 0; i<size;i++) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int check = current[2];
			
			if(x==n-1&&y==m-1) {
				search = true;
				break;
			}
			
			for(int j = 0; j<4;j++) {
				int cx = x+dx[j];
				int cy = y+dy[j];
				
				if(cx<0||cy<0||cx>n-1||cy>m-1) {
					continue;
				}
				
				
				if(check==0) {
					if(arr[cx][cy]==1) {
						if(!visited[cx][cy][1]) {
							visited[cx][cy][1] = true;
							q2.add(new int[] {cx,cy,1});
						}
					}
					else {
						if(!visited[cx][cy][0]) {
							visited[cx][cy][0] = true;
							q2.add(new int[] {cx,cy,0});
							
						}
						
					}
				}
				else {
					if(arr[cx][cy]==0&&!visited[cx][cy][1]) {
						visited[cx][cy][1] = true;
						q2.add(new int[] {cx,cy,1});
					}
				}
				
			}
		}
		q = q2;
	}
}
