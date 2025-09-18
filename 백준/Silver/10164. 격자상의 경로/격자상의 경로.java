import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		if(k==0) {
			System.out.print(com(n+m-2,n-1));
		}
		else {
			k--;
			int x = k/m;
			int y = k%m;
			System.out.println(com(x+y,x)*com(n-x+m-y-2,n-x-1));
		}
	}
	static long com(int a,int b) {
		long total = 1;
		b = Math.max(b, a-b);
		for(int i = 1;i<=b;i++) {
			total *= a+1-i;
			total /= i;
		}
		return Math.max(total,1);
	}
}