import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] fib0 = new int[41];
		int[] fib1 = new int[41];
		fib0[0] = 1;
		fib1[0] = 0;
		fib0[1] = 0;
		fib1[1] = 1;
		for(int i =0; i<N; i++) {
			int b = sc.nextInt();
			for(int j = 2; j<=b; j++) {
				fib0[j] = fib0[j-1]+fib0[j-2];
				fib1[j] = fib1[j-1]+fib1[j-2];
			}
			System.out.println(fib0[b]+" "+ fib1[b]);
		}
		sc.close();
	}
}
