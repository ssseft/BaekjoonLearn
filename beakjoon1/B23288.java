package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B23288 {
	static int n;
	static int m;
	static int[][] score;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int[][]arr;
	static boolean[][] visited;
	static int[] dice;
	static int direction;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		score = new int[n][m];
		//점수판 구하기
		cal();
		
		int result = 0;
		//동 서 남 북 위 아래
		dice = new int[]{3,4,5,2,1,6};
		//동 서 남 북 (0123)
		direction = 0;
		int[] current = new int[]{0,0};
		
		for(int i=0;i<k;i++) {
			if(direction==0){
				if(current[1]==m-1) {
					direction = 1;
				}
			}
			else if(direction==1) {
				if(current[1]==0) {
					direction = 0;
				}
			}
			else if(direction==2) {
				if(current[0]==n-1) {
					direction = 3;
				}
			}
			else {
				if(current[0]==0) {
					direction = 2;
				}
			}
			
			roll(direction);
			current[0] += dy[direction];
		    current[1] += dx[direction];
			result+= score[current[0]][current[1]];
			
			if(dice[5]>arr[current[0]][current[1]] ) {
				if(direction ==0) {
					direction = 2;
				}
				else if(direction==1) {
					direction = 3;
				}
				else if(direction==2) {
					direction = 1;
				}
				else {
					direction = 0;
				}
			}
			else if(dice[5]<arr[current[0]][current[1]]) {
				if(direction ==0) {
					direction = 3;
				}
				else if(direction==1) {
					direction = 2;
				}
				else if(direction==2) {
					direction = 0;
				}
				else {
					direction = 1;
				}
			}
		}
		
		System.out.println(result);
		
	}
	public static void roll(int d) {
		// 동 서 남 북
		int temp = dice[4];
		if(d==0) {
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[0];
			dice[0] = temp;
		}
		else if(d==1) {
			dice[4] = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		}
		else if(d==2) {
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		}
		else {
			dice[4] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		}
	}
	
	
	public static void cal() {
		visited = new boolean[n][m];
		for(int i = 0; i<n;i++) {
			for(int j =0;j<m;j++) {
				if(!visited[i][j]) {
					List<int[]> list = new ArrayList<>();
					list.add(new int[] {i,j});
					visited[i][j] = true;
					dfs(i,j,list);
					int value = list.size()*arr[i][j];
					for(int a = 0; a<list.size();a++) {
						int[] c = list.get(a);
						score[c[0]][c[1]] = value;
					}
				}
			}
		}
	}
	public static void dfs(int x, int y,List<int[]> list) {
		for(int i = 0;i <4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&arr[x][y]==arr[cx][cy]) {
				visited[cx][cy] = true;
				list.add(new int[] {cx,cy});
				dfs(cx,cy,list);
			}
		}
	}
}
