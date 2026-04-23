import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int[] reverse_dp = new int[n];
        
        for(int i = n-1; i>=0;i--) {
        	reverse_dp[i] = 0;
        	for(int j = n-1;j>=i;j--) {
        		if(arr[i]>arr[j]) {
        			reverse_dp[i] = Math.max(reverse_dp[i], reverse_dp[j]+1);
        		}
        	}
        }
        int max = 0;
        for(int i =0; i<n;i++) {
        	max = Math.max(max, dp[i]+reverse_dp[i]);
        }
        
        System.out.print(max);
        
    }
}
