package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B14499 {
	static int[] dice = new int[6];
	static int[][] arr;
	static int[] process;
	static int x;
	static int y;
	static int n;
	static int m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		process = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<k;i++) {
			process[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =0 ;i<k;i++) {
			tumble(process[i]);
		}
	}
	public static void tumble(int direction) {
		int cx = x+dx[direction-1];
		int cy = y+dy[direction-1];
		if(cx>=0&&cy>=0&&cx<n&&cy<m) {
			int temp = dice[0];
			if(direction == 1) { // 동
				dice[0] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[3];
				dice[3] = temp;
			}
			else if(direction == 2) { //서
				dice[0] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[5];
				dice[5] = temp;
			}
			else if(direction == 3) {
				dice[0] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
			}
			else if(direction ==4){
				dice[0] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[2];
				dice[2] = temp;
			}
			if(arr[cx][cy] == 0) {
				arr[cx][cy] = dice[1];
			}
			else {
				dice[1] = arr[cx][cy];
				arr[cx][cy] = 0;
			}
			x = cx;
			y = cy;
			System.out.println(dice[0]);
			
		}
	}
}
