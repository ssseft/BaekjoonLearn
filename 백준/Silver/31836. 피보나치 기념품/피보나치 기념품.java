import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==2) {
			System.out.println(1);
			System.out.println(1);
			System.out.println(1);
			System.out.println(2);
			return;
		}
		int[] p = new int[n+1];
		p[1] = p[2] = 1;
		
		for(int i = 3;i<=n;i++) {
			p[i] = p[i-1]+p[i-2];
		}
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		int t = n/3;
		int t2 = n/3*2;
		if(n%3==0) {
			for(int i = 1;i<=n;i++) {
				if(i%3==0) a.append(i+" ");
				else b.append(i+" ");
			}
		}
		else if(n%3==1) {
			for(int i = 2;i<=n;i++) {
				if(i%3==1) a.append(i+" ");
				else b.append(i+" ");
			}
		}
		else {
			a.append(1+" ");
			b.append(2+" ");
			t++;
			t2++;
			for(int i = 3;i<=n;i++) {
				if(i%3==2) a.append(i+" ");
				else b.append(i+" ");
			}
		}
		System.out.println(t);
		System.out.println(a);
		System.out.println(t2);
		System.out.println(b);
	}
}