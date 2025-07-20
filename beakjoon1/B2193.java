package beakjoon1;
import java.util.Scanner;

public class B2193 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		long[] zero = new long[91];
		long[] one = new long[91];
		
		zero[1] = 0;
		zero[2] = 1;
		one[1] = 1;
		one[2] = 0;
		for(int i =3;i<91;i++) {
			one[i] = zero[i-1];
			zero[i] = one[i-1]+zero[i-1];
		}
		
		System.out.println(zero[n]+one[n]);
	}
}
