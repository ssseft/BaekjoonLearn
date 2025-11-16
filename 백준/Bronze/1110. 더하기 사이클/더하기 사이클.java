import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = n;
		int cnt = 0;
		while(true) {
			int num1 = c%10;
			int num2 = (c%10)*10 + ((c/10+c%10)%10);
			int next = num1*10+num2%10;
			c = next;
			cnt++;
			if(next==n) {
				System.out.print(cnt);
				break;
			}
		}
	}
}