import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            BigInteger sum = BigInteger.ZERO;

            for (int j = 0; j < n; j++) {
                BigInteger c = sc.nextBigInteger();
                sum = sum.add(c).mod(BigInteger.valueOf(n));
            }

            if (sum.equals(BigInteger.ZERO))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}