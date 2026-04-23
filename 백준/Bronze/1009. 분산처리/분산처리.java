import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int c = 0;
			int score = 1;
			if(num1%10 == 0|| num1%10 == 1 || num1%10 == 5|| num1%10 == 6) {
				score = num1%10;
			}
			else if(num1%10 == 4|| num1%10 == 9) {
				c = num2%2;
				if(c == 0) {
					c =2;
				}
			}
			else {
				c = num2%4;
				if(c ==0) {
					c =4;
				}
			}
			
			for(int j =0; j<c; j++) {
				score = (score*num1)%10;
			}
			if(score==0) {
				score =10;
			}
			System.out.println(score);
		}
		sc.close();
		
	}
}
