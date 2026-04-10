import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0;i<3;i++) {
			int c = sc.nextInt();
			sum += Math.min(c, n);
		}
		System.out.print(sum);
	}
}