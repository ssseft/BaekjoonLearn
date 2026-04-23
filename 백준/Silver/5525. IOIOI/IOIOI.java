import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		int rule =0;
		int result =0;
		for(int i = 2; i<m;i++) {
			if(s.charAt(i) == 'I'&&s.charAt(i-1) =='O'&&s.charAt(i-2)=='I') {
				i++;
				rule++;
			}
			else {
				rule =0;
			}
			
			if(rule >= n) {
				result++;
			}
		}
		System.out.print(result);
	}
}
