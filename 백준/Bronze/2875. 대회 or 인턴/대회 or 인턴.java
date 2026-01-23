import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int cnt = 0;
		while(true) {
			if(n<2) break;
			if(m<1) break;
			n-=2;
			m-=1;
			if(n+m<k) break;
			cnt++;
		}
		System.out.print(cnt);
	}
}
