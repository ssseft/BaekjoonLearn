package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {
	static int[] night_x = {-2,-2,-1,-1,1,1,2,2};
	static int[] night_y = {1,-1,2,-2,2,-2,1,-1};
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<int[]> q;
	static boolean[][] wall;
	static int n;
	static int m;
	static boolean[][] visited;
	static boolean check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		wall = new boolean[n][m];
		visited = new boolean[n][m];
		check = false;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==1) {
					wall[j][i] = true;
				}
			}
		}
		
		int result = k;
		q = new LinkedList<>();
		q.add(new int[] {0,0});
		
		//나이트 이동
		while(k>0) {
			q = night();
			k--;
		}
		
		visited = new boolean[n][m];
		
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
		//한칸이동
		while(!q.isEmpty()) {
			q = bfs();
			result++;
			if(check) break;
			
		}
		
		System.out.println(result);
		
	}
	static Queue<int[]> bfs(){
		Queue<int[]> q2 = new LinkedList<>();
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0] + dx[i];
				int cy = c[1] + dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&!wall[cx][cy]) {
					q2.add(new int[] {cx,cy});
					visited[cx][cy] = true;
					if(cx==n-1&&cy==m-1) check = true;
				}
				
			}
			
		}
		
		return q2;
	}
	static Queue<int[]> night(){
		Queue<int[]> q2 = new LinkedList<>();
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0; i<8;i++) {
				int cx = c[0]+night_x[i];
				int cy = c[1]+night_y[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&!wall[cx][cy]) {
					q2.add(new int[] {cx,cy});
				}
			}
		}
		return q2;
	}
	
	
}
