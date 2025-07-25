package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17822 {
	static int n,m;
	static int[][] plate;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		plate = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=  0;j<m;j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<int[]> list = new ArrayList<>();
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotation(x,d,k);
			list = search();
			if(list.isEmpty()) {
				adjust();
			}
			else {
				for(int[] c : list) {
					plate[c[0]][c[1]] = 0;
				}
			}
		}
		
		int score = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				score+=plate[i][j];
			}
		}
		System.out.print(score);
	}
	static void adjust() {
		int sum = 0;
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(plate[i][j]!=0) {
					sum+=plate[i][j];
					cnt++;
				}
			}
		}
		
		if(cnt==0) return;
		
		float average = (float)sum/cnt;
		
		for(int i =0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(plate[i][j]==0) continue;
				if(plate[i][j]>average) plate[i][j]--;
				else if(plate[i][j]<average) plate[i][j]++;
			}
		}
	}
	static void rotation(int x, int d, int k) {
		//x의 배수를 d의 방향(0 시계 1 반시계)으로 k칸 이동
		for(int i = 0;i<n;i++) {
			if((i+1)%x!=0) continue;
			int[] temp = new int[m];
			for(int j=0;j<m;j++) {
				if(d==0) {
					temp[(j+k)%m] = plate[i][j];
				}
				else {
					temp[(j-k+m)%m] = plate[i][j];
				}
			}
			plate[i] = temp;
		}
	}
	static List<int[]> search(){
		List<int[]> list = new ArrayList<>();
		boolean[][] visited = new boolean[n][m];
        boolean found = false;
        
		for(int i = 0;i<n;i++) {
			for(int j= 0;j<m;j++) {
				if(plate[i][j]==0) continue;;
				
				int a1 = plate[i][j];
				int a2 = plate[i][(j+1)%m];
				if(a1==a2) {
					visited[i][j] =true;
                    visited[i][(j+1)%m] =true;
                    found = true;
				}
				
				if(i!=n-1) {
					int b1 = plate[i+1][j];
					if(a1==b1) {
						visited[i][j] =true;
	                    visited[i+1][j] =true;
	                    found = true;
					}
				}
			}
		}
		if(!found) return list;
		for(int i=0;i<n;i++) {
            for(int j=0; j<m;j++) {
                if(visited[i][j]) {
                    list.add(new int[]{i,j});
                }
            }
        }
		
		return list;
	}
}
