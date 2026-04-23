import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t;i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			int floor = n%h;
			if(floor==0) {
				floor = h;
			}
			int room = (n-1)/h+1;
			System.out.print(floor);
			if(room/10==0) {
				System.out.print("0"+room);
			}
			else {
				System.out.print(room);
			}
			System.out.println();
		}
	}
}