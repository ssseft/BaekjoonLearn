import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static int n;
	static int[][] field;
	static boolean[][] cloud;
	static boolean[][] new_cloud;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		field = new int[n+1][n+1];
		
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud = new boolean[n+1][n+1];
		cloud[n][1]= true;
		cloud[n][2]= true;
		cloud[n-1][1]= true;
		cloud[n-1][2]= true;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d,s);
			cloud = new boolean[n+1][n+1];
			CopyAndCreate();
		}
		
		int total = 0;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				total+=field[i][j];
			}
		}
		System.out.print(total);
	}
	static void CopyAndCreate() {
		int[][] plus = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				if(i<n) {
					if(j>1) {
						if(field[i][j]>0&&new_cloud[i+1][j-1]) {
							plus[i+1][j-1]++;
						}
					}
					if(j<n) {
						if(field[i][j]>0&&new_cloud[i+1][j+1]) {
							plus[i+1][j+1]++;
						}
					}
				}
				if(i>1) {
					if(j>1) {
						if(field[i][j]>0&&new_cloud[i-1][j-1]) {
							plus[i-1][j-1]++;
						}
					}
					if(j<n) {
						if(field[i][j]>0&&new_cloud[i-1][j+1]) {
							plus[i-1][j+1]++;
						}
					}
				}
			}
		}
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				field[i][j] += plus[i][j];
				if(field[i][j]>1&&!new_cloud[i][j]) {
					cloud[i][j] = true;
					field[i][j]-=2;
				}
			}
		}
	}
	static void move(int d, int s) {
		new_cloud = new boolean[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				if(cloud[i][j]) {
					int cx = (i+dx[d]*s+n*25)%n;
					int cy = (j+dy[d]*s+n*25)%n;
					if(cx==0) cx = n;
					if(cy==0) cy = n;
					new_cloud[cx][cy] = true;
					field[cx][cy]++;
				}
			}
		}
	}
}
