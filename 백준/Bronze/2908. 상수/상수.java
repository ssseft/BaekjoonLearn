import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int a1 = a%10;
		a /= 10;
		int a2 = a%10;
		a /= 10;
		int A = a+a2*10+a1*100;
		
		int b1 = b%10;
		b /= 10;
		int b2 = b%10;
		b /= 10;
		int B = b+b2*10+b1*100;
		
		System.out.print(Math.max(A, B));
	}
}
