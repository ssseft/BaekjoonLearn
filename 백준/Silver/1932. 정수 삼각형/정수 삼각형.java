import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int [n][n];
		int[][] result = new int[n][n];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <n; i++) {
			for(int j = 0; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		result[0][0] = arr[0][0];
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				if(j == 0) {
					result[i][j] = arr[i][j]+result[i-1][j];
				}
				else if(j == i) {
					result[i][j] = arr[i][j]+result[i-1][j-1];
				}
				else {
					result[i][j] = arr[i][j]+Math.max(result[i-1][j-1],result[i-1][j]);
				}
			}
		}
		for (int j = 0; j < n; j++) {
	        if (result[n-1][j] > max) {
	            max = result[n-1][j];
	        }
	    }
		System.out.print(max);
	}
}