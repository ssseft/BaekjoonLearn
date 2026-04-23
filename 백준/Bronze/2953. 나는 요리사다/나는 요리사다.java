
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int s = 0;
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		for(int i = 1;i<=5;i++) {
			int sum = 0;
			for(int j = 0;j<4;j++) {
				int a = sc.nextInt();
				sum +=a;
			}
			if(sum>max) {
				s = i;
				max = sum;
			}
		}
		System.out.println(s+" "+max);
	}
}
