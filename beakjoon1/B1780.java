package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B1780 {
	static int minus;
	static int zero;
	static int plus;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr =new int[n][n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minus = 0;
		zero = 0;
		plus = 0;
		conquer(0,0,n);
		if(minus==0&&zero==0&&plus==0) {
			if(arr[0][0]>0) {
				plus++;
			}
			else if(arr[0][0]==0) {
				zero++;
			}
			else {
				minus++;
			}
		}
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		
	}
	public static int conquer(int x, int y, int size) {
		if(size==1) {
			return arr[x][y];
		}
		int newsize = size/3;
		
		int[] area = new int[9];
		
		area[0] = conquer(x,y,newsize);
		area[1] = conquer(x+newsize,y,newsize);
		area[2] = conquer(x+2*newsize,y,newsize);
		area[3] = conquer(x,y+newsize,newsize);
		area[4] = conquer(x+newsize,y+newsize,newsize);
		area[5] = conquer(x+2*newsize,y+newsize,newsize);
		area[6] = conquer(x,y+2*newsize,newsize);
		area[7] = conquer(x+newsize,y+2*newsize,newsize);
		area[8] = conquer(x+2*newsize,y+2*newsize,newsize);
		
		int m = 0;
		int z = 0;
		int p = 0;
		
		for(int i = 0; i<9;i++) {
			if(area[i] == 1) {
				p++;
			}
			else if(area[i] == 0) {
				z++;
			}
			else if(area[i] == -1) {
				m++;
			}
		}
		if(p==9) {
			return 1;
		}
		else if(z==9) {
			return 0;
		}
		else if(m==9) {
			return -1;
		}else {
			plus += p;
			zero += z;
			minus += m;
			return -2;
		}
	}
}
