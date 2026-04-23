import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		
		for(int i = -999; i<1000; i++) {
			for(int j = -999; j<1000; j++) {
				if(a*i+b*j==c) {
					if(A*i+B*j==C) {
						System.out.print(i+" "+j);
					}
				}
			}
		}
	}
}