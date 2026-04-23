import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		
		if(a == 0 && b<45) {
			System.out.print("23 "+(b+15));
		}
		else if(b>=45) {
			System.out.print(a+" "+(b-45));
		}
		else {
			System.out.print((a-1)+" "+(b+15));
		}
		
	}
}
