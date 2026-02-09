import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.print(re(re(x)+re(y)));
	}
	static int re(int a) {
		int d = 0;
		int cnt = String.valueOf(a).length();
		while(cnt-->0) {
			int c = a%10;
			a/=10;
			d += Math.pow(10,cnt)*c;
		}
		return d;
	}
}
