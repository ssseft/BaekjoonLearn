package beakjoon1;

import java.util.Scanner;

public class B1024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		sc.close();
		// x = (n-(l*(l-1))/2)/2
		
		StringBuilder sb = new StringBuilder();
		for(int i = l;i<101;i++) {
			if(no(i,n)){
				int x = (n-(i*(i-1)/2))/i;
				
				for(int j = 0;j<i;j++	) {
					sb.append((x+j)+" ");
				}
				break;
			}
		}
		if(sb.length()==0) {
			System.out.print(-1);
			return;
		}
		System.out.print(sb.toString());
		
	}
	static boolean no(int i, int n) {
		int value = n-(i*(i-1))/2 ;
		return value%i==0&&value/i>=0;
	}
}
