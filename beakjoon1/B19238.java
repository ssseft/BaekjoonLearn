package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[n][n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken())-1;
		int sy = Integer.parseInt(st.nextToken())-1;
		
		List<int[]> list = new ArrayList<>();
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken())-1;
			int starty = Integer.parseInt(st.nextToken())-1;
			int endx = Integer.parseInt(st.nextToken())-1;
			int endy = Integer.parseInt(st.nextToken())-1;
			field[startx][starty] = i+2;
			list.add(new int[] {endx,endy});
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		Queue<int[]> q = new LinkedList<>();
		
		boolean[][] visited;
		
		for(int i = 0;i<m;i++) {
			//목표 탐색
			q.clear();
			q.add(new int[] {sx,sy});
			int choiceidx[] = new int[2];
			int minx = Integer.MAX_VALUE;
			int miny = Integer.MAX_VALUE;
			int cnt = 0;
			boolean search = false;
			visited = new boolean[n][n];
			visited[sx][sy]	= true;
			if(field[sx][sy]>1) {
				search = true;
				choiceidx = new int[] {sx,sy};
			}
			
			while(!q.isEmpty()&&!search) {
				int size = q.size();
				for(int j = 0;j<size;j++) {
					int[] c = q.poll();
					int x = c[0];
					int y = c[1];
					
					for(int k = 0;k<4;k++) {
						int cx = x+dx[k];
						int cy = y+dy[k];
						if(cx>=0&&cy>=0&&cx<n&&cy<n&&field[cx][cy]!=1&&!visited[cx][cy]) {
							if(field[cx][cy]>1) {
								if(minx==cx) {
									if(miny>cy) {
										miny = cy;
										choiceidx = new int[]{cx,cy};
										visited[cx][cy] = true;
									}
								}
								else if(minx>cx) {
									minx = cx;
									miny = cy;
									choiceidx = new int[] {cx,cy};
									visited[cx][cy] = true;
								}
								search = true;
							}
							else {
								q.add(new int[] {cx,cy});
								visited[cx][cy] = true;
								
							}
						}
					}
				}
				cnt++;
			}
			if(fuel<cnt||!search) {
				System.out.print(-1);
				return;
			}
			fuel-=cnt;
			
			//목적지 거리 탐색
			q.clear();
			
			int startx = choiceidx[0];
			int starty = choiceidx[1];
			int goalx = list.get(field[startx][starty]-2)[0];
			int goaly = list.get(field[startx][starty]-2)[1];
			field[startx][starty] = 0;
			cnt = 0;
			q.add(new int[] {startx,starty});
			search = false;
			
			sx = goalx;
			sy = goaly;
			visited = new boolean[n][n];
			visited[startx][starty] = true;
			while(!q.isEmpty()&&!search) {
				
				int size = q.size();
				for(int j = 0;j<size;j++) {
					int[] c = q.poll();
					int x = c[0];
					int y = c[1];
					for(int k = 0;k<4;k++) {
						int cx = x+dx[k];
						int cy = y+dy[k];
						if(cx>=0&&cy>=0&&cx<n&&cy<n&&field[cx][cy]!=1&&!visited[cx][cy]) {
							if(cx==goalx&&cy==goaly) {
								search = true;
							}
							visited[cx][cy] = true;
							q.add(new int[] {cx,cy});
						}
						if(search) break;
					}
					if(search) break;
				}
				cnt++;
			}
			if(cnt>fuel||!search) {
				System.out.print(-1);
				return;
			}
			fuel+= cnt;
		}
		System.out.print(fuel);
	}
}
