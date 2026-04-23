import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		sc.close();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<a.length();i++) {
			char c = a.charAt(i);
			if(c>95) {
				sb.append(Character.toUpperCase(c));
			}
			else {
				sb.append(Character.toLowerCase(c));
			}
		}
		System.out.print(sb.toString());
	}
}
