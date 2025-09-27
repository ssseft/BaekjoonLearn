import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<3;i++) {
			int n = sc.nextInt();
			BigInteger sum = BigInteger.ZERO;
			for(int j=0;j<n;j++) {
				sum = sum.add(sc.nextBigInteger());
			}
			if(sum.equals(BigInteger.ZERO)) {
				System.out.println(0);
			}
			else if(sum.compareTo(BigInteger.ZERO)>0) {
				System.out.println("+");
			}
			else {
				System.out.println("-");
			}
		}
	}
}
