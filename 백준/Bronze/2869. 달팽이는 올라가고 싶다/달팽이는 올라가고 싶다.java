import java.util.Scanner;

public class Main {
	public static void main(String[] asgs) {
		Scanner sc =  new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		int count = (c-a)/(a-b)+1;
		int d = (c-a)%(a-b);
		
		
		if(d > 0 ) {
			count++;
		}
		
		System.out.print(count);
	}
}