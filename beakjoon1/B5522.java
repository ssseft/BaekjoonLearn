package beakjoon1;

import java.util.Scanner;

public class B5522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		for(int i = 0;i<5;i++) {
			int a = sc.nextInt();
			s+=a;
		}
		System.out.print(s);
	}
}