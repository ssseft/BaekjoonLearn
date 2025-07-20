package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B14502 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] arr;
	static int n;
	static int m;
	static boolean check[][];
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<m;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[n][m];
		int size = n*m;
		int max = 0;
		for(int a = 1; a<=size-2;a++) {
			for(int b = a+1; b<=size-1;b++) {
				for(int c = b+1; c<=size;c++) {
					int w1 = arr[(a-1)/m][(a-1)%m];
					int w2 = arr[(b-1)/m][(b-1)%m];
					int w3 = arr[(c-1)/m][(c-1)%m];
					if(w1==0&&w2==0&&w3==0) {
						arr[(a-1)/m][(a-1)%m] = 1;
						arr[(b-1)/m][(b-1)%m] = 1;
						arr[(c-1)/m][(c-1)%m] = 1;
						for(int i =0; i<n;i++) {
							for(int j =0; j<m;j++) {
								if(arr[i][j]==2) {
									BFS(i,j);
								}
							}
						}
						int sum =0;
						for(int d = 0; d<n;d++) {
							for(int e =0; e<m;e++) {
								if(!check[d][e]&&arr[d][e]==0) {
									sum++;
								}
							}
						}
						
						max = Math.max(max, sum);
						
						arr[(a-1)/m][(a-1)%m] = 0;
						arr[(b-1)/m][(b-1)%m] = 0;
						arr[(c-1)/m][(c-1)%m] = 0;
						
						check = new boolean[n][m];
					
					}
				}
			}
		}
		System.out.print(max);
	}
	public static void BFS(int x, int y) {
		for(int i =0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!check[cx][cy]&&arr[cx][cy]==0) {
				check[cx][cy] = true;
				BFS(cx,cy);
			}
		}
	}
}
