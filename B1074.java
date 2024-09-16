package beakjun;
import java.util.Scanner;

public class B1074 {
	public static int[][] arr;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int size = (int)Math.pow(2, n);
		arr = new int[size][size];
		
		ZZ(arr,n,0,0);
		
		System.out.print(arr[r][c]);
		
	}
	public static void ZZ(int[][] arr,int n, int x,int y) {
		if(n == 1) {
			arr[x][y+1] = arr[x][y]+1;
			arr[x+1][y] = arr[x][y]+2;
			arr[x+1][y+1] = arr[x][y]+3;
		}
		else {
			int newsize = n*n/4;
			arr[0][(int)Math.pow(2, n-1)] = newsize;
			arr[(int)Math.pow(2, n-1)][0] = 2*newsize;
			arr[(int)Math.pow(2, n-1)][(int)Math.pow(2, n-1)] = 3*newsize;
			
			
			
			ZZ(arr,n-1,(int)Math.pow(2, n-1),0);
			ZZ(arr,n-1,0,(int)Math.pow(2, n-1));
			ZZ(arr,n-1,(int)Math.pow(2, n-1),(int)Math.pow(2, n-1));
			n--;
		}
	}
}
