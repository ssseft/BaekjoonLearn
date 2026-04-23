import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int count = 0;
		if(N<100)
			System.out.print(N);
		else{
			for(int i =100; i<=N;i++) {
			int fir = i/100;
			int sec = (i/10)%10;
			int thi = i%10;
			if(fir - sec== sec - thi) {
				count++;
			}
			}

			System.out.println(99+count);
		}
	}
}
