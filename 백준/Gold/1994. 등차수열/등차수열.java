import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i < n; i++) 
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int[][] dp = new int[n][n];
		int max = 1;
		for(int i = 0;i<n-1;i++) {
			for(int j = i+1;j<n;j++) {
				dp[i][j] = 2;
				int target = arr[i]-(arr[j]-arr[i]);
				int left = 0;
				int right = i-1;
				int k = -1;
				while(left<=right){
					int mid = (left+right)>>1;
					if(arr[mid]==target) {
						if(arr[left]==target) {
							if(arr[right]==target) k = right;
							else k = left;
							break;
						}
						left = mid;
					}
					else if(arr[mid]>target) right = mid-1;
					else left = mid+1;
				}
				if(k!=-1) dp[i][j] = dp[k][i]+1;
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.print(max);
	}
}