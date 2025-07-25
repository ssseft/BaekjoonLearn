package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1799 {
	static int max;
	static int n;
	static List<int[]> list;
	static List<int[]> list2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					if((i+j)%2!=1) {
						list.add(new int[] {i,j});
					}
					else {
						list2.add(new int[] {i,j});
					}
				}
			}
		}
		max = 0;
		
		boolean[][] temp = new boolean[n][n];
		
		backtracking(list,0, 0, temp);
		int cnt = 0;
		cnt += max;
		max = 0;
		backtracking(list2,0, 0, temp);
		cnt+=max;
		System.out.println(cnt);
		
		
	}
	static void backtracking(List<int[]> list,int idx, int cnt,boolean[][] temp) {
		max = Math.max(max, cnt);
		if(list.size()==idx) {
			return;
		}
		
		if(possible(list.get(idx)[0], list.get(idx)[1], temp)) {
			temp[list.get(idx)[0]][list.get(idx)[1]] = true;
			backtracking(list, idx+1, cnt+1, temp);
			temp[list.get(idx)[0]][list.get(idx)[1]] = false;
		}
		backtracking(list, idx+1, cnt, temp);
		
		
	}
	static int[] dx = {-1,-1,1,1};
	static int[] dy = {-1,1,1,-1};
	static boolean possible(int x ,int y,boolean[][] temp) {
		if(temp[x][y]) return false;
		for(int i = 0;i<4;i++) {
			int d = 1;
			while(true) {
				int cx = x+d*dx[i];
				int cy = y+d*dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<n) {
					if(temp[cx][cy]) {
						return false;
					}
				}
				else break;
				d++;
			}
		}
		return true;
	}
}
