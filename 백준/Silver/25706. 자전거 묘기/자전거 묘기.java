import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[n];
		for(int i = n-1;i>=0;i--) {
			int c = arr[i];
			if(i+c+1>=n) dp[i] = 1;
			else dp[i] = dp[i+c+1]+1;
		}
		for(int i = 0;i<n;i++) System.out.print(dp[i]+" ");
		
	}
}
