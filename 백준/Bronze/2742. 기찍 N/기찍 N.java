import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sc.close();
		for(int i = n;i>=1;i--) {
			sb.append(i+"\n");
		}
		System.out.print(sb.toString().trim());
		
	}
}
