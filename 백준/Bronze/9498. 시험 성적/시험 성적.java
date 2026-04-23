import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			sc.close();
			
			if(a>=90) {
				System.out.println("A");
			}
			else if (80<=a&&90>a) {
				System.out.println("B");
			}
			else if (70<=a&&80>a) {
				System.out.println("C");
			}
			else if (60<=a&&70>a) {
				System.out.println("D");
			}
			else {
				System.out.println("F");
			}
	}
}