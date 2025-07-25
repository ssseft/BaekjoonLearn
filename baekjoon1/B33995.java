package beakjoon1;

import java.util.Scanner;

public class B33995 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		String word = sc.next();
		int[] alp = new int[26];
		
		for(int i = 0;i<n;i++) {
			int c = word.charAt(i) - 'a';
			alp[c]++;
		}
		
		int min = n;
		
		for(int i = 0;i<26;i++) {
			min = Math.min(min, alp[i]);
		}
		
		if(min>k) System.out.println(0);
		else System.out.println(1);
	}
}
