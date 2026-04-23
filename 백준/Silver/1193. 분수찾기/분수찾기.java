import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		int sum = 0;
		int cnt = 1;
		
		while(sum+cnt<X) {
			sum+=cnt;
			cnt++;
		}
		int num = X-sum;
		if(cnt%2==1) {
			System.out.print((cnt+1-num)+"/"+num);
		}
		else {
			System.out.print(num+"/"+(cnt+1-num));
		}
	}
}
