package beakjoon1;

import java.math.BigInteger;
import java.util.Scanner;

public class B10757 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		sc.close();
		System.out.print(a.add(b));
	}
}
