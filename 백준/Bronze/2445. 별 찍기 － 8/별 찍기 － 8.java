import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i =0; i<N; i++) {
			for(int j =0; j<i+1;j++) {
				System.out.print("*");
			}
			for(int k =i+1;k<2*N-i-1;k++) {
				System.out.print(" ");
			}
			for(int l =0;l<i+1;l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int j =0;j<N-1; j++ ) {
			for(int i =0; i<N-j-1;i++) {
				System.out.print("*");
			}
			for(int k=0; k<2*(j+1);k++) {
				System.out.print(" ");
			}
			for(int l =0; l<N-j-1;l++) {
				System.out.print("*");
			}
			
			
			System.out.println();
		}
		
	}
}
