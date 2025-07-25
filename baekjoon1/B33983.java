package beakjoon1;

import java.util.Scanner;

public class B33983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String w = sc.next();
		sc.close();
		int hcnt = 0;
		for(int i = 0;i<n;i++) {
			if(w.charAt(i)=='H') hcnt++;
		}
		if(n%3!=0||(n/3)*2!=hcnt) {
			System.out.print("mix");
			return;
		}
		boolean mix = false;
		hcnt = 0;
		int ocnt = 0;
		for(int i = 0;i<n;i++) {
			char c = w.charAt(i);
			if(c=='H') hcnt++;
			else {
				if(hcnt-ocnt<1||(n/3)*2-hcnt<(n/3)-ocnt) {
					mix = true;
					break;
				}
				ocnt++;
			}
		}
		
		if(mix) System.out.println("mix");
		else System.out.println("pure");
	}
}
