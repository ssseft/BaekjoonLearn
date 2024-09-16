package beakjun;
import java.util.Scanner;

public class B2630 {
	
	public static int blue = 0;
	public static int white = 0;
	public static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		part(0,0,n);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void part(int row, int col, int size) {
		if(colorCheck(row,col,size)) {
			if(arr[row][col] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		int partsize = size/2;
		part(row,col,partsize);
		part(row,col+partsize,partsize);
		part(row+partsize,col,partsize);
		part(row+partsize,col+partsize,partsize);
	}
	
	
	
	public static boolean colorCheck(int row,int col, int size) {
		
		int standard = arr[row][col];
		
		for(int i = row; i<row+size;i++) {
			for(int j = col; j<col+size;j++) {
				if(arr[i][j] != standard) {
					return false;
				}
				
			}
		}
		return true;
	}
}
