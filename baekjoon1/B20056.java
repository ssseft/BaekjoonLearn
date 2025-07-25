package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B20056 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<int[]>list = new ArrayList<>();
		
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new int[] {r,c,w,s,d});
		}
		int[] dx = {-1,-1,0,1,1,1,0,-1};
		int[] dy = {0,1,1,1,0,-1,-1,-1};
		int[][][] sum = new int[n+1][n+1][3]; //w s d
		int[][] cnt = new int[n+1][n+1];
		int[][] dir = new int[n+1][n+1];
		while(k-->0) {
			//이동 및 더하기
			//r c w s d
			for(int[] c : list) {
				int cx = c[0]+ dx[c[4]]*c[3];
				int cy = c[1]+ dy[c[4]]*c[3];
				while(cx<1) cx+=n;
				while(cx>n) cx-=n;
				while(cy<1) cy+=n;
				while(cy>n) cy-=n;
				sum[cx][cy][0] += c[2];
				sum[cx][cy][1] += c[3];
				if(c[4]%2==1) sum[cx][cy][2] |= 1;
				else sum[cx][cy][2] |= 2;
				if(cnt[cx][cy]==0)dir[cx][cy] = c[4];
				cnt[cx][cy]++;
			}
			list.clear();
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=n;j++) {
					int[] c = sum[i][j];
					if(cnt[i][j]==1) {
						list.add(new int[]{i, j, c[0], c[1],dir[i][j]});
					}
					else if(c[0]>=5) {
						int neww = c[0]/5;
						int news = c[1]/cnt[i][j];
						if(c[2]!=3) {
							for(int a = 0;a<7;a+=2) {
								list.add(new int[] {i,j,neww,news,a});
							}
						}
						else {
							for(int a = 1;a<=7;a+=2) {
								list.add(new int[] {i,j,neww,news,a});
							}
						}
					}
					sum[i][j][0] = 0;
					sum[i][j][1] = 0;
					sum[i][j][2] = 0;
					cnt[i][j] = 0;
					dir[i][j] = 0;
				}
			}
		}
		
		int sumw = 0;
		for(int[] c : list) {
			sumw+=c[2];
		}
		System.out.print(sumw);
		
	}
}
