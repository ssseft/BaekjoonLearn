package beakjun;
import java.util.Scanner;

public class B1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.close();
		int b = 666;
		int count = 1;
		
		while(count !=a) {
			b++;
			if(String.valueOf(b).contains("666")) {
				count++;
				
			}
			
			
		}
		if(count == a) {
			System.out.print(b);
		}
	
		
		
	}
}
