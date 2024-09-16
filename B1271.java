package beakjun;
import java.util.Scanner;
import java.math.BigInteger;

public class B1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		System.out.println(n.divide(m));
		System.out.print(n.remainder(m));
		sc.close();
	}
}
