package beakjun;
import java.util.Scanner;

public class B11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int result = factorial(n) / (factorial(k) * factorial(n-k));
		
		System.out.print(result);
		
	}
	public static int factorial(int num) {
		if(num <= 1) {
			return 1;
		}
		else {
			return factorial(num-1) * num;
		}
	}
}
