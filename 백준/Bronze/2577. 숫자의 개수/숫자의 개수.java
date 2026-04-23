import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		int d = a*b*c;
		String e = Integer.toString(d);
		
		for(int i = 0; i<10; i++) {
			int f = 0;
			for(int j = 0; j<e.length();j++) {
				if((e.charAt(j) - 48)== i) {
					f++;
				}
			}
			System.out.println(f);
		}
		
		
	}
}
