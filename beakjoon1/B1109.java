package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1109 {
	static int n,m;
	static int[][] field;
	static char[][] arr;
	static Queue<int[]> q;
	static int[] dx = {0,0,-1,1,1,1,-1,-1};
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	static boolean[][] visited;
	static int idx;
	static int[] h,parent;
	static boolean[] land;
	static List<List<int[]>> landcell;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		for(int i = 0;i<n;i++) {
			String line = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[n][m];
		
		field = new int[n][m];
		landcell.add(null);
		
		q = new LinkedList<>();
		idx = 1;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr[i][j]=='x'&&!visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] {i,j});
					field[i][j] = idx;
					List<int[]> list = new ArrayList<>();
					bfs(list);
					idx++;
				}
			}
		}
		
		if(idx==1) {
			System.out.print(-1);
			return;
		}
		
		h = new int[idx];
		land = new boolean[idx];
		parent = new int[idx];
		Arrays.fill(parent, -1);
		idx = 1;
		visited = new boolean[n][m];
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			if(!visited[i][0]) {
				q.add(new int[] {i,0});
				visited[i][0] = true;
				if(field[i][0]!=0) {
					if(!land[field[i][0]]) {
						parent[field[i][0]] = 0;
						list.add(new int[] {i,0});
					}
				}
			}
			
			if(!visited[i][m-1]) {
				q.add(new int[] {i,m-1});
				visited[i][m-1] = true;
				if(field[i][m-1]!=0) {
					if(!land[field[i][m-1]]) {
						parent[field[i][m-1]] = 0;
						list.add(new int[] {i,m-1});
					}
				}
			}
		}
		for(int i = 1;i<m;i++) {
			if(!visited[0][i]) {
				q.add(new int[] {0,i});
				visited[0][i] = true;
				if(field[0][i]!=0) {
					if(!land[field[0][i]]) {
						parent[field[0][i]] = 0;
						list.add(new int[] {0,i});
					}
				}
			}
			if(!visited[n-1][i]) {
				q.add(new int[] {n-1,i});
				visited[n-1][i] = true;
				if(field[n-1][i]!=0) {
					if(!land[field[n-1][i]]) {
						parent[field[n-1][i]] = 0;
						list.add(new int[] {n-1,i});
					}
				}
			}
		}
		
		recursion(list);
		
		
	}
	static void recursion(List<int[]> list) {
		
		
		
	}
	static void search() {
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			for(int i = 0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&field[x][y]==field[cx][cy]&&!visited[cx][cy]) {
					q.add(new int[] {cx,cy});
					visited[cx][cy] = true;
				}
			}
		}
	}
	
	static void bfs(List<int[]> list) {
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			for(int i = 0;i<8;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]=='x'&&!visited[cx][cy]) {
					visited[cx][cy] = true;
					q.add(new int[] {cx,cy});
					field[cx][cy] = idx;
					list.add(new int[] {cx,cy});
				}
			}
		}
		landcell.add(list);
	}
}
