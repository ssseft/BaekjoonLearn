package beakjun;
import java.util.Scanner;

public class B28097 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = 0;
		for(int i = 0; i<N; i++) {
			sum += sc.nextInt();
		}
		sc.close();
		
		
		if(N == 1) {
			if(sum/24 == 0) {
				System.out.print(0+" "+sum);
			}
			else {
				System.out.print(1+" "+sum%24);
			}
			
		}
		else {
			sum = sum+ (N-1)*8;
			int day = sum/24;
			int hour = sum%24;
			System.out.print(day+" "+hour);
			
			
		}
		
		
	}
}
