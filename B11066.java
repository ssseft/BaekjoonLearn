package beakjun;
import java.util.Scanner;

public class B11066 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i<t; i++) {
			int k = sc.nextInt();
			int[] arr = new int[k];
			for(int j = 0; j<k; j++) {
				arr[j] = sc.nextInt();
			}
			
			int[][] dp = new int[k][k];
			
			for(int q =0;q<k;q++) {
				dp[q][q] = 0;
			}
			
			for(int gap = 1; gap<k; gap++) {
				for(int w = 0;w<k-gap;w++) {
					int e = w+gap;
					dp[w][e] = Integer.MAX_VALUE;
					for(int r = w; r<e; r++) {
						dp[w][e] = Math.min(dp[w][e], dp[w][r]+dp[r+1][e]);
					}
					int sum = 0;
					for(int s = w; s<e+1;s++) {
						sum += arr[s];
					}
					dp[w][e] += sum;
				}
			}
			System.out.println(dp[0][k-1]);
		}
		sc.close();
		
	}
}
