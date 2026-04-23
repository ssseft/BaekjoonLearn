import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = 0;
		if(a==b||b==c||a==c) {
			if(a==b&&b==c) {
				result = a*1000+10000;
			}
			else {
				if(a==b||b==c) {
					result = b*100+1000;
				}
				else {
					result = c*100+1000;
				}
			}
		}
		else {
			result = Math.max(a, Math.max(b, c))*100;
		}
		System.out.print(result);
	}
}
