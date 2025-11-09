import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		int sum = 0;
		for(int i = 0;i<l.length();i++) {
			int s = l.charAt(i)<='9' ? l.charAt(i)-'0' : l.charAt(i)-'A'+10;
			sum += Math.pow(16, l.length()-1-i)*s;
		}
		System.out.print(sum);
	}
}
