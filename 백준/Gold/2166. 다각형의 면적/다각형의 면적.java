import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[n][2];
		for(int i = 0;i<n;i++) {
			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();
		}
		
		long a = 0;
		long b = 0;
		
		for(int i = 0;i<n-1;i++) {
			a += arr[i][0] * arr[i+1][1];
			b += arr[i][1] * arr[i+1][0];
		}
		a += arr[n-1][0] * arr[0][1];
		b += arr[n-1][1] * arr[0][0];
		
		double total = Math.abs(a-b);
		total /= 2;
		System.out.printf("%.1f",total);
	}
}