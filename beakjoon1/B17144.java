package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B17144 {
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int r;
	static int c;
	static int t;
	static int air;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		//y축 == r x축 == c
		//t초 뒤 전체 먼지 수 
		
		
		int[][] arr = new int[r][c];
		air = 0;
		for(int i = 0; i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					air = i; // 그러면 공기청정기는 (i-1,0),(i,0)이됨
				}
			}
		}
		
		for(int i = 0; i<t;i++) {
			int[][] arr2 = new int[r][c];
			for(int j = 0; j<r;j++) {
				for(int k = 0; k<c;k++) {
					if(arr[j][k]>0) {
						spread(j,k,arr,arr2);
					}
					
				}
			}
			arr2[air-1][0] = -1;
			arr2[air][0] = -1;
			
			
			for(int j = air-2;j>0;j--) {
				arr2[j][0] = arr2[j-1][0]; 
			}
			for(int j = 0;j<c-1;j++) {
				arr2[0][j] = arr2[0][j+1];
			}
			for(int j = 0;j<air-1;j++) {
				arr2[j][c-1] = arr2[j+1][c-1];
			}
			for(int j = c-1;j>1;j--) {
				arr2[air-1][j] = arr2[air-1][j-1];
			}
			arr2[air-1][1] = 0;
			
			for(int j = air+1;j<r-1;j++) {
				arr2[j][0] = arr2[j+1][0];
			}
			for(int j = 0;j<c-1;j++) {
				arr2[r-1][j] = arr2[r-1][j+1];
			}
			for(int j = r-1;j>air;j--) {
				arr2[j][c-1] = arr2[j-1][c-1];
			}
			for(int j = c-1;j>1;j--) {
				arr2[air][j] = arr2[air][j-1];
			}
			arr2[air][1] = 0;
			arr = arr2;
		}
		int sum = 0;
		for(int i = 0; i<r;i++) {
			for(int j = 0;j<c;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.print(sum+2);
		
		
	}
	public static void spread(int x, int y,int[][] arr,int[][] arr2) {
		int num = arr[x][y]/5;
		arr2[x][y]+= arr[x][y]-(num*4);
		
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if (cx >=0&&cy>=0&&cx<r&&cy<c&& !(cx==air&&cy==0)&&!(cx==air-1&&cy==0)) {
                arr2[cx][cy] += num;
            } else {
                arr2[x][y] += num;
            }
		}
	}
}
