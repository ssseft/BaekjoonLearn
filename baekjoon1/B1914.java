package beakjoon1;

import java.math.BigInteger;
import java.util.Scanner;

public class B1914 {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		sb = new StringBuilder();
		BigInteger a = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
		sb.append(a+"\n");
		if(n<=20) hanoi(n,1,2,3);
		System.out.print(sb.toString().trim());
	}
	static void hanoi(int n, int from, int temp, int to) {
		if(n==1) {
			sb.append(from+" "+to+"\n");
			return;
		}
		hanoi(n-1,from,to,temp);
		sb.append(from+" "+to+"\n");
		hanoi(n-1,temp,from,to);
	}
}
