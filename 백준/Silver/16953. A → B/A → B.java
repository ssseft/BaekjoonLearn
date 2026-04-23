import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result =0;
		
		while(true) {
			
			if(b==a) {
				break;
			}
			if(b<a) {
				result = -2;
				break;
			}
			
			if(b%2 != 0 && b%10 != 1) {
				result = -2;
				break;
			}
			
			if(b%2 ==0) {
				b /= 2;
			}else {
				b /= 10;
			}
			result++;
		}
		System.out.print(result+1);
	}
}
