package beakjun;
import java.util.Scanner;

public class B8958 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i =0; i<a; i++) {
			
			String b = sc.next();
			int score = 0;
			int sum =0;
			for(int j =0; j<b.length(); j++) {
				
				if(b.charAt(j)=='O') {
					score ++;
					sum +=score;
				}
				else {
					score = 0;
				}
			}
			
			System.out.println(sum);
			
		}
		
		sc.close();
	}
}
