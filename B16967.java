package beakjun;
import java.util.Scanner;

public class B16967 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] arr = new int[h+x][w+y];
		for(int i =0; i<h+x;i++) {
			for(int j =0; j<w+y;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=x;i<h+x;i++) {
			for(int j=y;j<w+y;j++) {
				arr[i][j] -= arr[i-x][j-y];
			}
		}
		for(int i =0; i<h;i++) {
			for(int j=0;j<w;j++) {
				sb.append(arr[i][j]+" ");
				
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}