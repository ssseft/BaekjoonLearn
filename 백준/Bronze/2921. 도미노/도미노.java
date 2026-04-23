import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		long[] arr = new long[1001];
		int cnt = 0;
		for(int i = 1;i<=1000;i++) {
			cnt+=i;
			arr[i] = arr[i-1]+i*(i+1)+cnt;
		}
		System.out.print(arr[n]);
	}
}
