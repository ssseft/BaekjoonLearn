import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] arr = new long[303];
		long[] sum = new long[303];
		sum[1] = 1;
		for(int i =2;i<303;i++) {
			sum[i] = sum[i-1]+i;
		}
		arr[1] = 3;
		
		for(int i = 2;i<302;i++) {
			arr[i] = arr[i-1]+ i*sum[i+1];
		}
		for(int i = 0;i<t;i++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}
}
