import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long result = 1;
		sc.close();
		
		for(int i =0; i<k-1; i++) {
			result *= (n-i+-1);
			result /= (i+1);
		}
		System.out.print(result);
		
	}
}
