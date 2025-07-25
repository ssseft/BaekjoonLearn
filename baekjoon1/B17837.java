package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17837 {
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static boolean exit;
	static int[] dir;
	static int[][] field,des;
	static List<Integer>[][] list;
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1][n+1];
		field = new int[n+1][n+1];
		dir = new int[k+1];
		exit = false;
		des = new int[k+1][2];
		
		
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1;j<=n;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 1;i<=k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[x][y].add(i);
			dir[i] = d;
			des[i][0] = x;
			des[i][1] = y;
		}
		
		
		
		int cnt = 0;
		while(!exit&&cnt<=1000) {
			for(int i = 1;i<=k;i++) {
				move(i);
				if(exit) break;
			}
			cnt++;
		}
		if(cnt==1001) System.out.print(-1);
		else System.out.print(cnt);
	}
	static void move(int num) {
		int x = des[num][0];
		int y = des[num][1];
		List<Integer> movelist = new ArrayList<>();
		int pivot = 0;
		int size = list[x][y].size();
		for(int i = 0;i<size;i++) {
			if(list[x][y].get(i)==num) {
				pivot = i;
				break;
			}
		}
		for(int i = 0;i<size-pivot;i++) {
			movelist.add(list[x][y].remove(pivot));
		}
		
		int cx = x+dx[dir[num]];
		int cy = y+dy[dir[num]];
		
		if(cx>=1&&cy>=1&&cx<=n&&cy<=n&&(field[cx][cy]==1||field[cx][cy]==0)) {
			if(field[cx][cy]==0) {
				for(int i = 0;i<movelist.size();i++) {
					list[cx][cy].add(movelist.get(i));
					des[movelist.get(i)][0] = cx;
					des[movelist.get(i)][1] = cy;
				}
			}
			else {
				for(int i = movelist.size()-1;i>=0;i--) {
					list[cx][cy].add(movelist.get(i));
					des[movelist.get(i)][0] = cx;
					des[movelist.get(i)][1] = cy;
				}
			}
			if(list[cx][cy].size()>=4) exit = true;
		}
		else {
			if(dir[num]%2==1) dir[num]++;
			else dir[num]--;
			cx = x+dx[dir[num]];
			cy = y+dy[dir[num]];
			
			if(cx>=1&&cy>=1&&cx<=n&&cy<=n&&(field[cx][cy]==1||field[cx][cy]==0)) {
				if(field[cx][cy]==0) {
					for(int i = 0;i<movelist.size();i++) {
						list[cx][cy].add(movelist.get(i));
						des[movelist.get(i)][0] = cx;
						des[movelist.get(i)][1] = cy;
					}
				}
				else {
					for(int i = movelist.size()-1;i>=0;i--) {
						list[cx][cy].add(movelist.get(i));
						des[movelist.get(i)][0] = cx;
						des[movelist.get(i)][1] = cy;
					}
				}
				if(list[cx][cy].size()>=4) exit = true;
			}
			else {
				for(int i =0;i<movelist.size();i++) {
					list[x][y].add(movelist.get(i));
				}
				if(list[x][y].size()>=4) exit = true;
			}
		}
	}
}
