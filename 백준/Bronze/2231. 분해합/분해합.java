import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.close();
		int c = 0;
		for(int i=0; i<a; i++) {
			int sum = i;
			int b = i;
			
			while(b>0) {
				sum+= b%10;
				b /=10;
				
			}
			
			if(sum == a) {
				c = i;
				break;
			}
		}
		
		
		System.out.print(c);
		
		
	}
}
