import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] ans = new long[16];
		ans[1] = 3;
		for(int i = 2;i<=15;i++) ans[i] = ans[i-1]*2-1;
		System.out.print(ans[n]*ans[n]);
	}
}