import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		sc.close();
		
		int min = Integer.MAX_VALUE;
		
		min = Math.min(min, x);
		min = Math.min(min, y);
		min = Math.min(min, w-x);
		min = Math.min(min, h-y);
		
		System.out.print(min);
		
	}
}
