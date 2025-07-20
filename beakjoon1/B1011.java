package beakjoon1;
import java.util.Scanner;

public class B1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sc.nextLine();
			int difference = y-x;
			
			if(difference==1) {
				sb.append(1+"\n");
			}
			else {
				int a = (int)Math.sqrt(difference-1);
				int result = a*2;
				int remainder = difference-1-(int)Math.pow(a, 2);
				if(remainder>=a) {
					result++;
				}
				sb.append(result+"\n");
			}
		}
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
