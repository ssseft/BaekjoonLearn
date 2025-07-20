package beakjoon1;

import java.util.Scanner;

public class B9086 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		StringBuilder sb=  new StringBuilder();
		for(int i = 0;i<t;i++) {
			String a = sc.nextLine();
			char a1 = a.charAt(0);
			char a2 = a.charAt(a.length()-1);
			sb.append(a1).append(a2).append("\n");
		}
		
		System.out.print(sb.toString().trim());
		sc.close();
	}
}
