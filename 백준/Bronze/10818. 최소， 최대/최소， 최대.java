import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int c = 1000001;
		int d = -1000001;
		
		for(int i = 0; i<a; i++) {
			int b = sc.nextInt();
			if(c>b) {
				c = b;
			}
			if(d<b) {
				d = b;
			}
		}
		
		
		sc.close();
		System.out.print(c+" "+d);
		
		
		
		
		
	}
}
