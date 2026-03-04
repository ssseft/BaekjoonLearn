import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int c1 = sc.nextInt();
		int s1 = a>a1 ? 0 : a1-a;
		int s2 = b>b1 ? 0 : b1-b;
		int s3 = c>c1 ? 0 : c1-c;
		System.out.print(s1+s2+s3);
	}
}
