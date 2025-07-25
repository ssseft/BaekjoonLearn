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

public class B19237 {
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num!=0) list.add(new int[] {i,j,num});
			}
		}
		Queue<int[]> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int[] direc = new int[m+1];
		for(int i = 1;i<=m;i++) {
			direc[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<list.size();i++) {
			int[] c = list.get(i);
			q.add(new int[] {c[0],c[1],c[2],direc[c[2]]});
			//x,y,num,dir
		}
		
		//1 2 3 4 위 아래 왼 오
		
		int[][][] shark = new int[m+1][5][5];
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=4;j++) {
				st = new StringTokenizer(br.readLine());
				for(int t=1;t<=4;t++) {
					shark[i][j][t] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int[][][] field = new int[n+1][n+1][2];//nun,k
		int[][] min = new int[n+1][n+1];
		
		int cnt = 0;
		while(cnt<=1000&&q.size()!=1) {
			//냄새 남기기
			int size=  q.size();
			list.clear();
			for(int i = 1;i<=n;i++) {
				Arrays.fill(min[i], Integer.MAX_VALUE);
			}
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				int x = c[0];
				int y = c[1];
				int num = c[2];
				field[x][y][0] = num;
				field[x][y][1] = k;
				q.add(c);
			}
			//상어 이동
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				int x = c[0];
				int y = c[1];
				int num = c[2];
				int dir = c[3];
				boolean search = false;
				for(int j = 1;j<=4;j++) {
					int cx = x+dx[shark[num][dir][j]];
					int cy = y+dy[shark[num][dir][j]];
					if(cx>=1&&cy>=1&&cx<=n&&cy<=n&&field[cx][cy][0]==0) {
						list.add(new int[] {cx,cy,num,shark[num][dir][j]});
						min[cx][cy] = Math.min(min[cx][cy], num);
						search = true;
						break;
					}
				}
				if(!search) {
					for(int j = 1;j<=4;j++) {
						int cx = x+dx[shark[num][dir][j]];
						int cy = y+dy[shark[num][dir][j]];
						if(cx>=1&&cy>=1&&cx<=n&&cy<=n&&field[cx][cy][0]==num) {
							list.add(new int[] {cx,cy,num,shark[num][dir][j]});
							min[cx][cy] = Math.min(min[cx][cy], num);
							break;
						}
					}
				}
			}
			//같은 칸에 있을경우 작은 번호만 남김
			
			for(int i = 0;i<list.size();i++) {
				int[] c =  list.get(i);
				int x = c[0];
				int y = c[1];
				int num = c[2];
				if(min[x][y]==num) q.add(c);
			}
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=n;j++) {
					if(field[i][j][1]>0) field[i][j][1]--;
					if(field[i][j][1]==0) field[i][j][0] = 0;
				}
			}
			
			cnt++;
			
		}
		if(cnt==1001) System.out.print(-1);
		else System.out.print(cnt);
	}
}
