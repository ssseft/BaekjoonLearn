import java.util.*;

class Main{
	public static void main(String[]s) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		int score = 1;
		int cur = 1;
		for(int i = 1;i<l.length();i++) {
			char b = l.charAt(i);
			char a = l.charAt(i-1);
			if(a<b) {
				cur++;
			}
			else {
				cur = 1;
			}
			score+=cur;
		}
		System.out.print(score);
	}
}
