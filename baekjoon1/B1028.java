package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1028 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] mine = new int[n][m];
		int max = 0;
		
		for(int i = 0;i<n;i++) {
			String l = br.readLine();
			for(int j = 0;j<m;j++) {
				mine[i][j] = l.charAt(j)-'0';
				if(mine[i][j]==1) max = 1;
			}
		}
		
		
		
		int[][][] up = new int[n][m][2]; //0은 왼쪽 1은 오른쪽
		int[][][] down = new int[n][m][2]; //0은 왼쪽 1은 오른쪽
		for(int i = 0;i<m;i++) {
			up[0][i][0] = mine[0][i];
			up[0][i][1] = mine[0][i];
			down[n-1][i][0] = mine[n-1][i];
			down[n-1][i][1] = mine[n-1][i];
		}
		
		for(int i =1;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(mine[i][j]==1) {
					up[i][j][0] = 1;
					up[i][j][1] = 1;
					if(j>0) up[i][j][0] += up[i-1][j-1][0]; 
					if(j<m-1) up[i][j][1] += up[i-1][j+1][1];
				}
			}
		}
		for(int i = n-2;i>=0;i--) {
			for(int j= 0;j<m;j++) {
				if(mine[i][j]==1) {
					down[i][j][0] = 1;
					down[i][j][1] = 1;
					if(j>0) down[i][j][1] += down[i+1][j-1][1];
					if(j<m-1) down[i][j][0] += down[i+1][j+1][0];
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m-max;j++) {
				if(mine[i][j]==0) continue;
				int a = Math.min(down[i][j][0], down[i][j][1]);
				
				for(int k = a;k>max;k--) {
					int b = i+(k-1)*2;
					if(b>=n) continue;
					if(up[b][j][0]>=k&&up[b][j][1]>=k) {
						max = k;
						break;
					}
				}
			}
		}
		
		System.out.print(max);
		
	}
}
