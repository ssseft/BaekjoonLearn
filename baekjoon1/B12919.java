package beakjoon1;

import java.util.Scanner;

public class B12919 {
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		check = false;
		String S = sc.nextLine();
		String T = sc.nextLine();
		recursion(S,T);
		if(check) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	//new StringBuilder(next).reverse().toString();
	public static void recursion(String S,String T) {
		if(S.length()==T.length()) {
			if(S.equals(T)) {
				check = true;
			}
			return;
		}
		if(T.charAt(T.length()-1)=='A') {
			String newT = new StringBuilder(T).deleteCharAt(T.length()-1).toString();
			recursion(S,newT);
		}
		if(T.charAt(0)=='B') {
			String newT = new StringBuilder(T).deleteCharAt(0).reverse().toString();
			recursion(S,newT);
		}
	}
}
