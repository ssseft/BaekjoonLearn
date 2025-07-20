package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B23289 {
	static int n,m,k;
	static int[][] room;
	static List<int[]> checkroom;
	static List<int[]> warmfan;
	static HashSet<String> dwall;
	static HashSet<String> rwall;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		room = new int[n][m];
		checkroom = new ArrayList<>();
		warmfan = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==5) {
					checkroom.add(new int[] {i,j});
					room[i][j] = 0;
				}
				else if(room[i][j]>0) {
					warmfan.add(new int[] {i,j,room[i][j]});
					room[i][j] = 0;
				}
			}
		}
		
		dwall = new HashSet<>();
		rwall = new HashSet<>();

		int w = Integer.parseInt(br.readLine());
		for(int i = 0;i<w;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int wall = Integer.parseInt(st.nextToken());
			x--;
			y--;
			if(wall==0) dwall.add((x-1)+" "+y);
			if(wall==1) rwall.add(x+" "+y);
		}
		
		int cnt = 0;
		
		while(cnt<=100) {
			operate();
			adjust();
			sidetemp();
			cnt++;
			if(check()) break;
		}
		
		System.out.print(cnt);
	}
	static void adjust() {
		int[][] nexttemp = new int[n][m];
		for(int i = 0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int org = room[i][j];
				for(int k = 1;k<5;k++) {
					int cx = i+dx[k];
					int cy = j+dy[k];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&room[i][j]>room[cx][cy]&&!wexist(i,j,cx,cy)) {
						int a = (room[i][j]-room[cx][cy])/4;
						nexttemp[cx][cy] += a;
						org -= a;
					}
				}
				nexttemp[i][j] += org;
			}
		}
		for(int i = 0;i<n;i++) {
			room[i] = nexttemp[i].clone();
		}
	}
	
	static int[][] get(int dir) {
	    if(dir==1) return new int[][]{{0, 1},{-1, 1},{1, 1}};
	    if(dir==2) return new int[][]{{0, -1},{-1, -1},{1, -1}};
	    if(dir==3) return new int[][]{{-1, 0},{-1, -1},{-1, 1}};
	    return new int[][]{{1, 0}, {1, -1}, {1, 1}};
	}
	static void operate() {
		int[][] uptemp = new int[n][m];
		
		
		Queue<int[]> q;
		
		for(int[] fan : warmfan) {
			int x = fan[0];
			int y = fan[1];
			int dir = fan[2];
			boolean[][] visited = new boolean[n][m];
			//동 서 북 남
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			
			q = new LinkedList<>();
			visited[nx][ny] = true;
			q.add(new int[] {nx,ny,5});
			uptemp[nx][ny] +=5;
			while(!q.isEmpty()) {
				int[] c =  q.poll();
				if(c[2]<2) continue;
				int[][] spread = get(dir);
				for(int[] d : spread) {
					int cx = c[0]+d[0];
					int cy = c[1]+d[1];
					if(cx>=0&&cy>=0&&cx<n&&cy<m) {
						if(!visited[cx][cy]&&cango(c[0],c[1],cx,cy,dir)){
							uptemp[cx][cy] += c[2]-1;
							visited[cx][cy] = true;
				            q.add(new int[]{cx,cy,c[2]-1});
						}
					}
				}
			}
		}
		for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	            room[i][j] += uptemp[i][j];
	        }
	    }
	}
	static boolean cango(int x, int y, int mvx, int mvy,int dir) {
		boolean check = true;
		if(dir==1) {
			if(x-mvx==1) {
				if(dwall.contains(mvx+" "+y)||rwall.contains(mvx+" "+y)) check = false;
			}
			else if(x-mvx==0) {
				if(rwall.contains(x+" "+y)) check = false;
			}
			else {
				if(dwall.contains(x+" "+y)||rwall.contains(mvx+" "+y)) check = false;
			}
		}
		else if(dir==2) {
			if(x-mvx==1) {
				if(rwall.contains(mvx+" "+mvy)||dwall.contains(mvx+" "+y)) check = false;
			}
			else if(x==mvx) {
				if(rwall.contains(mvx+" "+mvy)) check = false;
			}
			else {
				if(rwall.contains(mvx+" "+mvy)||dwall.contains(x+" "+y)) check = false;
			}
		}
		else if(dir==3) {
			if(y-mvy==1) {
				if(dwall.contains(mvx+" "+mvy)||rwall.contains(x+" "+mvy)) check = false;
			}
			else if(y==mvy) {
				if(dwall.contains(mvx+" "+mvy)) check = false;
			}
			else {
				if(rwall.contains(x+" "+y)||dwall.contains(mvx+" "+mvy)) check = false;
			}
		}
		else {
			if(y-mvy==1) {
				if(rwall.contains(x+" "+mvy)||dwall.contains(x+" "+mvy)) check = false;
			}
			else if(y==mvy) {
				if(dwall.contains(x+" "+y)) check = false;
			}
			else {
				if(rwall.contains(x+" "+y)||dwall.contains(x+" "+mvy)) check = false;
			}
		}
		return check;
	}


	static boolean wexist(int x, int y,int mvx,int mvy) {
		boolean check = false;
		if(x==mvx) {
			if(y<mvy) {
				if(rwall.contains(x+" "+y)) check = true;
			}
			else {
				if(rwall.contains(x+" "+mvy)) check = true;
			}
		}
		else {
			if(x<mvx) {
				if(dwall.contains(x+" "+y)) check = true;
			}
			else {
				if(dwall.contains(mvx+" "+y)) check = true;
			}
		}
		return check;
	}
	
	static void sidetemp() {
		for(int i =0;i<n;i++) {
			if(room[i][0]>0) room[i][0]--;
			if(room[i][m-1]>0) room[i][m-1]--;
		}
		for(int i =1;i<m-1;i++) {
			if(room[0][i]>0) room[0][i]--;
			if(room[n-1][i]>0) room[n-1][i]--;
		}
	}
	
	static boolean check() {
		boolean ch = true;
		for(int[] c : checkroom) {
			if(room[c[0]][c[1]]<k) {
				ch = false;
				break;
			}
		}
		return ch;
	}
}	
