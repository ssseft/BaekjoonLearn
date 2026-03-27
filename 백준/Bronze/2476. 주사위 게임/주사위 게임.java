import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		for(int i = 0;i<n;i++) {
			int sum = 0;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==b&&b==c) sum += 10000+a*1000;
			else if(a==b||a==c) {
				sum += 1000+a*100;
			}
			else if(b==c) {
				sum += 1000+b*100;
			}
			else {
				sum += Math.max(Math.max(a, b), c)*100;
			}
			max = Math.max(sum, max);
		}
		System.out.print(max);
	}
}