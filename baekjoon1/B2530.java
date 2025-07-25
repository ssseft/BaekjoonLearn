package beakjoon1;

import java.util.Scanner;

public class B2530 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int d = sc.nextInt();
		
		int m = (d+c)/60;
		c = (d+c)%60;
		
		int h = (m+b)/60;
		b = (m+b)%60;
		
		a = (a+h)%24;
		
		System.out.print(a+" "+b+" "+c);
		
	}
}
