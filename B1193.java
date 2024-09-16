package beakjun;
import java.util.Scanner;

public class B1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		 int line = 1;
		 while (X > line) {
	            X -= line;
	            line++;
	        }
		 int numerator, denominator;
		 if (line % 2 == 0) {
	            numerator = X;
	            denominator = line - X + 1;
		 }
		 else {
	            numerator = line - X + 1;
	            denominator = X;
		 }
		 System.out.println(numerator + "/" + denominator);
		 sc.close();
	      
	}
}
