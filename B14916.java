package beakjun;
import java.util.Scanner;

public class B14916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		if(n == 1 || n == 3) {
			System.out.print(-1);
		}
		else if(n%5 == 0){
			System.out.print(n/5);
		}
		else {
			int count = 0;
			int quo = n/5-1;
			int rem = n%5;
			count += quo;
			if(rem == 1 || rem ==4 ) {
				count +=3;
			}
			else if(rem == 2 ) {
				count+=2;
			}
			else {
				count +=4;
			}
			
			System.out.print(count);
		}
	}
}