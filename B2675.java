package beakjun;
import java.util.Scanner;

public class B2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		
		for(int k=0; k<a; k++) {
			int b = sc.nextInt();
			String c = sc.next();
			
			
			
			for(int i=0;i<c.length();i++){
				for(int j=0;j<b;j++) {
					System.out.print(c.charAt(i));
				}
				
			}
			System.out.println();
		}
		sc.close();
	}
		
}
