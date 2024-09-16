package beakjun;
import java.util.Scanner;

public class B2501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		boolean[] A = new boolean[N+1];
		for(int i = 1; i<=N;i++) {
			if(N%i == 0) {
				A[i] = true;
			}
		}
		int count =0;
		for(int i =1; i<=N;i++) {
			if(A[i]) {
				count++;
				if(count == K) {
					System.out.print(i);
					return;
				}
			}
			
		}
		System.out.print(0);
	}
}