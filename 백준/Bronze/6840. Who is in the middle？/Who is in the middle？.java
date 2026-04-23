import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		if(a<b) a2++;
		else {
			a1++;
		}
		
		if(b<c) a3++;
		else {
			a2++;
		}
		
		if(c<a) a1++;
		else {
			a3++;
		}
		
		if(a1==1) {
			System.out.println(a);
		}
		if(a2==1) {
			System.out.println(b);
		}
		if(a3==1) {
			System.out.println(c);
		}
		
		
		sc.close();
		
		
		
		
	}
}
