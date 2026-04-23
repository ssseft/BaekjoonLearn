import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int q = n/5;
		int r = n%5;
		if(n==4||n==7) System.out.println(-1);
		else if(r==0) System.out.print(q);
		else if(r==1||r==3) System.out.print(q+1);
		else System.out.print(q+2);
	}
}
