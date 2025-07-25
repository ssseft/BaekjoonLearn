package beakjoon1;

import java.util.Scanner;

public class B33931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if((m/n)%2==1) System.out.print(n-(m%n));
		else System.out.print(m%n);
	}
}