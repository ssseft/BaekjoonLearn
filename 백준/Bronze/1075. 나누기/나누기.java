import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		int e = a/100*100;
		
		
		int c = e%b;
		int d = b-c;
		
		if(e%b ==0 ) {
			System.out.print("00");
		}
		else if(d<10) {
			System.out.print("0"+d);
		}
		else {
			System.out.print(d);
		}
	}
}
