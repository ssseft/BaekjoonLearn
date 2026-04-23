import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int a = 1;
		int b = 2;
		
		if(N==1) {
			System.out.println(1);
		}
		else {
		while(b<=N) {
			b = b+(6*a);
			a++;
		}
		
		System.out.print(a);
		}
	}
}
