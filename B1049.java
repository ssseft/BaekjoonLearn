package beakjun;
import java.util.Scanner;

public class B1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[m][2];
		int sixstringmin = Integer.MAX_VALUE;
		int onestringmin = Integer.MAX_VALUE;
		for(int i = 0; i<m; i++) {
			arr[i][0] = sc.nextInt();
			if(arr[i][0]<sixstringmin) {
				sixstringmin = arr[i][0];
			}
			arr[i][1] = sc.nextInt();
			if(arr[i][1]<onestringmin) {
				onestringmin = arr[i][1];
			}
		}
		int sum =0;
		while(n>0) {
			if(n>=6) {
				if(6*onestringmin<sixstringmin) {
					sum += 6*onestringmin;
					
				}
				else {
					sum += sixstringmin;
				}
				n -= 6;
			}
			else {
				if(n*onestringmin<sixstringmin) {
					sum += n*onestringmin;
					
				}
				else {
					sum += sixstringmin;
				}
				n = 0;
			}
		}
		System.out.print(sum);
		sc.close();
	}
}
