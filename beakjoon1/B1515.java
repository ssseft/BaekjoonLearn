package beakjoon1;

import java.util.Scanner;

public class B1515 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		sc.close();
		
		int number = 1;
		int idx = 0;
		
		while(idx<num.length()) {
			String s = Integer.toString(number);
			for(int i = 0;i<s.length();i++) {
				if(idx<num.length()&&s.charAt(i)==num.charAt(idx)) {
					idx++;
				}
			}
			number++;
		}
		System.out.println(number-1);
	}
}
