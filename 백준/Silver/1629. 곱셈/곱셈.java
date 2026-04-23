import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		sc.close();
		long result = exp(a,b,c);
		
		System.out.print(result);
		
	}
	
	public static long exp(long a, long b, long c) {
		if(b==0) {
			return 1;
		}
		if(b%2 == 1) {
			return (a*exp(a,b-1,c))%c;
		}
		else {
			long d = exp(a,b/2,c)%c;
			return (d*d)%c;
		}
	}
}
