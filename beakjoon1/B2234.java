package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2234 {
	static boolean[][] visited;
	static int n;
	static int m;
	static int[][] arr;
	static int[][] field;
	static int idx = 1;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[m][n];
		field = new int[m][n];
		int[] room = new int[n*m+1];
		int maxroom = 0;
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(!visited[i][j]) {
					room[idx] = bfs(i,j);
					maxroom = Math.max(maxroom, room[idx]);
					idx++;
				}
			}
		}
		List<Integer>[] list = new ArrayList[idx+1];
		for(int i = 1;i<idx+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				for(int k =0;k<4;k++) {
					int cx = i+dx[k];
					int cy = j+dy[k];
					if(cx>=0&&cy>=0&&cx<m&&cy<n) {
						if(field[cx][cy]!=field[i][j]) {
							if(!list[field[i][j]].contains(field[cx][cy])) {
								list[field[i][j]].add(field[cx][cy]);
							}
						}
					}
				}
			}
		}
		int max = 0;
		
		for(int i = 1;i<idx;i++) {
			int size = list[i].size();
			for(int j = 0;j<size;j++) {
				int roomnum = list[i].get(j);
				if(i<list[i].get(j)) {
					max = Math.max(max, room[i]+room[roomnum]);
				}
			}
		}
		
		
		System.out.println(idx-1);
		System.out.println(maxroom);
		System.out.println(max);
		
	}
	
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		visited[x][y] = true;
		field[x][y] = idx;
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<m&&cy<n&&!visited[cx][cy]) {
					if((arr[c[0]][c[1]]&(1<<i))==0) {
						visited[cx][cy] = true;
						field[cx][cy] = idx;
						q.add(new int[] {cx,cy});
						
					}
				}
			}
			cnt++;
		}
		
		return cnt;
	}
}
