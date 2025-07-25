package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683 {
	static List<Integer> list;
	static int n;
	static int m;
	static int min;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		list = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i<n;i++	) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0&&arr[i][j]<6) {
					list.add(i*m+j);
				}
			}
		}
		
		cal(0);
		// 1 한방향 2 양방향 3 ㄱ자 4 3방향 5 전체방향
		System.out.print(min);
		
		
		
		
	}
	public static void cal(int index) {
		if(index == list.size()) {
			int cnt = 0;
			for(int i = 0;i <n;i++) {
				for(int j = 0; j<m;j++) {
					if(arr[i][j]==0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		
		int current = list.get(index);
		int type = arr[current/m][current%m];
		int[][][] directions = {
	            {{0}, {1}, {2}, {3}},
	            {{0, 1}, {2, 3}},
	            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
	            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
	            {{0, 1, 2, 3}}};

	        for (int[] dir : directions[type-1]) {
	        	List<Integer> checkarea = new ArrayList<>();
	            area(current/m, current%m, dir, checkarea);
	            cal(index+1);
	            for(int a : checkarea) {
	            	arr[a/m][a%m]= 0;
	            }
	        }
	}
	public static void area(int x, int y, int[] direction, List<Integer> checkarea) {
		for(int d : direction) {
			int nx = x;
			int ny = y;
			while(true) {
				nx += dx[d];
				ny += dy[d];
				if(nx<0||ny<0||nx>=n||ny>=m||arr[nx][ny]==6) {
					break;
				}
				else {
					if(arr[nx][ny] == 0 ) {
						checkarea.add(nx*m+ny);
						arr[nx][ny] = -1;
					}
				}
			}
		}
	}
}
