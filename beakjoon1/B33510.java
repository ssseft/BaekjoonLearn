package beakjoon1;

import java.util.Scanner;

public class B33510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String x = sc.next();
		int cnt = 0;
		sc.close();
		int idx = 0;
		for(int i = n-1;i>=1;i--) {
			int c = x.charAt(i)-'0';
			if(c==0&&idx==0) {
				idx = 0;
			}
			else if(c+idx==1) {
				cnt++;
				if(c==1) {
					idx=1;
				}
			}
			else {
				idx = 1;
			}
		}
		System.out.println(cnt);
	}
}
