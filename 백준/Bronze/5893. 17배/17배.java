import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = new BigInteger(sc.nextLine(),2).multiply(new BigInteger("17"));
		System.out.println(n.toString(2));
	}
}
