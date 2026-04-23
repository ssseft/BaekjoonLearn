import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int c = 0;
		for(int i =0; i<a; i++) {
			int b = sc.nextInt();
			int count =0;
			for(int j = 1; j<b+1; j++  ) {
				if(b%j == 0){
					count++;
					
					}
				}
			if(count == 2) {
				c++;
			
			}
			
			
		}
		sc.close();
		System.out.print(c);
		
		
		
		
	}
}
