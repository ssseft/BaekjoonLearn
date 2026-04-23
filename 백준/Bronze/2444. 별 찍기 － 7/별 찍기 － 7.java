import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            for(int l =i; l>0;l--) {
            	System.out.print("*");
            }
            System.out.println();
		}
		for(int j =0; j<N-1; j++) {
			for(int i =0; i<j+1; i++) {
				System.out.print(" ");
			}
			for(int k =j+1; k<N; k++) {
				System.out.print("*");
			}
			for(int l=N-2; l>j;l--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
