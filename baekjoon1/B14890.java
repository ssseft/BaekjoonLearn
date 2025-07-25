package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B14890 {
	static int n;
	static int L;
	static int[][] arr;
	static int score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		score = 0;
		for(int i =0; i<n;i++) {
			XCal(0,i,0,0);
			YCal(i,0,0,0);
		}
		System.out.println(score);
		
		
		
	}
	public static void XCal(int x, int y,int count, int prenum) {
		if(x==0) {
			prenum = arr[x][y];
		}
		if(x==n) {
			score++;
			return;
		}
		
		
		if(arr[x][y] == prenum) {
			XCal(x+1,y,count+1,prenum);
		}
		else {
			if(Math.abs(prenum-arr[x][y])>1) {
				return;
			}
			else {
				if(prenum<arr[x][y]) {
					if(count<L) {
						return;
					}
					else {
						XCal(x+1,y,1,arr[x][y]);
					}
				}
				else {//현재 위치가 더 작을 때
					if(n-x<L) {
						return;
					}
					else {
						for(int i = 1; i<L;i++) {
							if(arr[x+i][y]!= arr[x][y]) {
								return;
							}
						}
						XCal(x+L,y,0,arr[x+L-1][y]);
					}
				}
			}
		}
	}
	public static void YCal(int x, int y,int count, int prenum) {
		if(y>=n) {
			score++;
			return;
		}
		if(y==0) {
			prenum = arr[x][y];
		}
		
		
		
		if(arr[x][y] == prenum) {
			YCal(x,y+1,count+1,prenum);
			return;
		}
		else {
			if(Math.abs(prenum-arr[x][y])>1) {
				return;
			}
			else {
				if(prenum<arr[x][y]) {
					if(count<L) {
						return;
					}
					else {
						YCal(x,y+1,1,arr[x][y]);
					}
				}
				else {//현재 위치가 더 작을 때
					if(n-y<L) {
						return;
					}
					else {
						for(int i = 0; i<L;i++) {
							if(arr[x][y+i]!= arr[x][y]) {
								return;
							}
						}
						YCal(x,y+L,0,arr[x][y+L-1]);
					}
				}
			}
		}
	}
}
