import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 100;
		int b = 100;
		for(int i = 0;i<n;i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			if(c>d) b -= c;
			else if(c<d) a -= d;
		}
		System.out.println(a);
		System.out.println(b);
	}
}