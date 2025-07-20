package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18500 {
	static int r;
	static int c;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r+1][c+1];
		
		for(int i = 1;i<=r;i++) {
			String line = br.readLine();
			for(int j =1;j<=c;j++) {
				char cur = line.charAt(j-1);
				arr[i][j] = cur;
			}
		}
		
		boolean left = true;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			int s = Integer.parseInt(st.nextToken());
			search(left,r-s+1);
			left = !left;
		}
		for(int i = 1;i<=r;i++) {
			for(int j =1;j<=c;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static void search(boolean left,int line) {
		int[] d = remove(left,line);
		if(d[1]==0) return;
		
		boolean[][] visited = new boolean[r+1][c+1];
		Queue<int[]> q = new LinkedList<>();
		for(int i = 1;i<=c;i++) {
			if(arr[r][i]=='x') {
				visited[r][i] = true;
				q.add(new int[] {r,i});
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=1&&cy>=1&&cx<=r&&cy<=c&&!visited[cx][cy]&&arr[cx][cy]=='x') {
					visited[cx][cy] = true;
					q.add(new int[] {cx,cy});
				}
			}
		}
		
		for(int i = 0;i<4;i++) {
	        int cx = d[0]+dx[i];
	        int cy = d[1]+dy[i];
	        if(cx>=1&&cy>=1&&cx<=r&&cy<=c&&arr[cx][cy]=='x'&&!visited[cx][cy]) {
	            Queue<int[]> clu = new LinkedList<>();
	            boolean[][] cluvisited = new boolean[r+1][c+1];
	            clu.add(new int[]{cx, cy});
	            cluvisited[cx][cy] = true;
	            
	            List<int[]> list = new LinkedList<>();
	            list.add(new int[]{cx, cy});
	            
	            while(!clu.isEmpty()) {
	                int[] cur = clu.poll();
	                int x = cur[0], y = cur[1];
	                for(int j=0;j<4;j++) {
	                    int nx = x+dx[j];
	                    int ny = y+dy[j];
	                    if(nx>=1&&ny>=1&&nx<=r&&ny<=c&&!visited[nx][ny]&&!cluvisited[nx][ny]&&arr[nx][ny]=='x') {
	                        cluvisited[nx][ny] = true;
	                        clu.add(new int[]{nx, ny});
	                        list.add(new int[]{nx, ny});
	                    }
	                }
	            }
	            
	            int min = r;
	            for(int[] pos : list) {
	                int x = pos[0];
	                int y = pos[1];
	                int drop = 0;
	                for(int nx=x+1; nx<=r; nx++) {
	                    if(arr[nx][y]=='x') {
	                        if(!cluvisited[nx][y]) break;
	                        else continue;
	                    }
	                    drop++;
	                }
	                min = Math.min(min, drop);
	            }
	            
	            for(int[] pos : list) {
	                arr[pos[0]][pos[1]] = '.';
	            }
	            for(int[] pos : list) {
	                arr[pos[0]+min][pos[1]] = 'x';
	            }
	            
	            break;
	        }
	    }
		
		
	}
	static int[] remove(boolean left,int line) {
		int a = 0;
		
		if(left) {
			for(int i = 1;i<=c;i++) {
				if(arr[line][i]=='x') {
					arr[line][i] = '.';
					a = i;
					break;
				}
			}
		}
		else {
			for(int i = c;i>=1;i--) {
				if(arr[line][i]=='x') {
					arr[line][i] = '.';
					a = i;
					break;
				}
			}
		}
		
		return new int[] {line,a};
	}
}
