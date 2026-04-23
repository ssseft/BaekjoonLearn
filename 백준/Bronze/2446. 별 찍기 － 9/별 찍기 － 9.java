import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<i; j++) {
				System.out.print(" ");
			}
			for(int k = i; k<2*N-i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int j = 0; j<N-1; j++) {
			for(int i = N-j-2; i>0; i--) {
				System.out.print(" ");
			}
			for(int k =0; k<2*(j+1)+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}