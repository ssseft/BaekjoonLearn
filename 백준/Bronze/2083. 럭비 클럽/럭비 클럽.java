import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			String name = sc.next();
			int a = sc.nextInt();
			int w = sc.nextInt();
			if(a==0) break;
			if(a>17||w>=80) sb.append(name+" Senior\n");
			else sb.append(name+" Junior\n");
		}
		
		System.out.print(sb.toString());
	}
}
