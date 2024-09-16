package beakjun;
import java.util.Scanner;

public class B2448 {
	public static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		arr = new boolean[n][2*n];
		for(int i =0; i<n; i++) {
			for(int j = n-i-1; j<n+i; j++) {
				arr[i][j] = true;
			}
		}
		
		rule(n,0,n);
		
		for(int i =0; i<n; i++) {
			for(int j =0; j<2*n;j++) {
				if(!arr[i][j]) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void rule(int size, int x, int y) {
		if(size ==3) {
			arr[x][y+1] = false;
			return;
		}
		
		int newsize = size/2;
		int gap = 1;
		for(int i = x-newsize+gap; i<x+newsize-gap;i++) {
			for(int j=y+newsize;j<y+size;j++) {
				arr[i][j] = false;
			}
			gap++;
		}
		
		
		
		rule(newsize,x,y);
		rule(newsize,x-newsize,y+newsize);
		rule(newsize,x+newsize,y+newsize);
	}
}