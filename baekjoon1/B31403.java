package beakjoon1;
import java.util.Scanner;

public class B31403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int b_1 = 0;
		b_1+= b;
		int cnt = 1;
		while(b_1>=10) {
			b_1/=10;
			cnt++;
		}
		int result = (a*(int)Math.pow(10, cnt)+b)-c;
		System.out.println((a+b)-c);
		System.out.print(result);
	}
}