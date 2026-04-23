import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) return;
			for(int i = 0;i<n;i++) {
				for(int j = n;j>=n-i;j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
