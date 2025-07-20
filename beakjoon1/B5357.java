package beakjoon1;

import java.util.Scanner;

public class B5357 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			String w = sc.next();
			char r = w.charAt(0);
			System.out.print(r);
			for(int i = 1;i<w.length();i++) {
				if(w.charAt(i)!=r) {
					r = w.charAt(i);
					System.out.print(r);
				}
			}
			System.out.println();
		}
	}
}
