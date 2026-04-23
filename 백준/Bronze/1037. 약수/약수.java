import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		long min = 1000001;
		long max = 0;
		
		for(int i = 0;i<n;i++) {
			int c = sc.nextInt();
			min = Math.min(min, c);
			max = Math.max(max, c);
		}
		sc.close();
		System.out.println(min*max);
		
		
	}
}
