import java.util.Scanner;

public class Main {
	public static void main(String[] asgs) {
		Scanner sc =  new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		int ss = a*b;
		while(b!=0) {
			int c = b;
			b = a%b;
			a = c;
		}
        int d = ss/a;
		System.out.println(a);
		System.out.println(d);
	}
}