package beakjoon1;

import java.util.Arrays;
import java.util.Scanner;

public class B17136 {
	static int cnt;
	static int[][] cp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cp = new int[10][10];
		int one = 0;
		for(int i = 0;i<100;i++) {
			cp[i/10][i%10] = sc.nextInt();
			if(cp[i/10][i%10]==1) one++;
		}
		cnt = 0;
		
		
		
	}
	static void backtracking() {
		
	}
}
