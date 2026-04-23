import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		if(N%2 == 0) {
			System.out.print("SK");
		}
		else {
			System.out.print("CY");
		}
	}
}
