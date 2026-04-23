import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		while(n>=1) {
			if(n%2==1) {
				cnt++;
			}
			n/=2;
		}
		System.out.print(cnt);
	}
}
