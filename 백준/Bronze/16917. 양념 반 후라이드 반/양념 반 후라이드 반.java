import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(a+b<c*2) {
			System.out.print(a*x+b*y);
		}
		else {
			int sum = 0;
			while(x>0&&y>0) {
				sum += c*2;
				x--;
				y--;
			}
			
			if(a>2*c) {
				sum += 2*c*x;
			}
			else {
				sum += a*x;
			}
			
			if(b>2*c) {
				sum += 2*c*y;
			}
			else {
				sum += b*y;
			}
			System.out.print(sum);
		}
	}
}