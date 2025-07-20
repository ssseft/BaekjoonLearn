package beakjoon1;

import java.util.*;

public class B33977{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		
		int dif = Integer.MAX_VALUE;
		int a = 1;
		int b = 1;
		for(int i =1;i*i<=n;i++) {
			if(n%i==0) {
				int c = n/i;
				int diff = Math.abs(i-c);
				if(diff<dif) {
					dif = diff;
					a = Math.max(i, c);
					b = Math.min(i, c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int total = a+b;
		sb.append(total+"\n");
		int idx = 2;
		for(int i = 1;i<=total-1-a;i++) {
			sb.append(i+" "+idx+++"\n");
			sb.append(i+" "+idx+++"\n");			
		}
		for(int i =total-a;i<=a;i++) {
			sb.append(i+" "+idx+++"\n");
		}
		System.out.println(sb.toString());
	}
}