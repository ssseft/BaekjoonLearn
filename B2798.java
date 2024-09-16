package beakjun;
import java.util.Scanner;

public class B2798 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int score = 0;
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i<N-2; i++) {
			for(int j = i+1; j<N-1;j++) {
				for(int k =j+1; k<N; k++) {
					int sum = arr[i]+arr[j]+arr[k];
					if(sum == M) {
						score = sum;
						break;
					}
					if(sum<M && sum>score) {
						score = sum;
					}
					
				}
			}
		}
		
		sc.close();
		System.out.print(score);
	}
}
