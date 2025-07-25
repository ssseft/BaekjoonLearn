package beakjoon1;

import java.util.Scanner;

public class B5596 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int c1 = sc.nextInt();
		int d1 = sc.nextInt();
		
		System.out.println(Math.max(a+b+c+d,a1+b1+c1+d1));
	}
}
