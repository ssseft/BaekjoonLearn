package beakjoon1;

import java.io.*;
import java.util.*;

public class B16946 {
	static Queue<int[]> q;
	static int[][] field;
	static int n,m;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		field = new int[n][m];
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			String c = br.readLine();
			for(int j = 0;j<m;j++) {
				field[i][j] = c.charAt(j)-'0';
			}
			arr[i] = field[i].clone();
		}
		
		q = new LinkedList<>();
		int idx = 2;
		int[] num = new int[n*m+2];
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(field[i][j]==0) {
					q.add(new int[] {i,j});
					num[idx] = bfs(idx);
					idx++;
				}
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(field[i][j]==1) {
					int[] seen = new int[4];
					int cnt = 1;
					int sc = 0;
					for(int k = 0;k<4;k++) {
						int cx = i+dx[k];
						int cy = j+dy[k];
						if(cx>=0&&cy>=0&&cx<n&&cy<m) {
							if(field[cx][cy]>1) {
								boolean ch = false;
								for(int a = 0;a<sc;a++) {
									if(seen[a]==field[cx][cy]) {
										ch = true;
										break;
									}
								}
								if(!ch) {
									seen[sc++] = field[cx][cy];
									cnt+=num[field[cx][cy]];
								}
							}
						}
					}
					arr[i][j] = cnt%10;
					
				}
			}
		}
		
		for(int i= 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				System.out.print(arr[i][j]);
			}
			if(i<n-1)System.out.println();
		}
	}
	
	static int bfs(int idx) {
		int cnt = 1;
		int[] a = q.poll();
		field[a[0]][a[1]] = idx;
		q.add(a);
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			for(int i =0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&field[cx][cy]==0) {
					q.add(new int[] {cx,cy});
					field[cx][cy] = idx;
					cnt++;
				}
			}
		}
		return cnt;

	}
}
