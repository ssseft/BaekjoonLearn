package beakjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int  i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n];
		for(int i = 0; i<n;i++) {
			dp[i] = 1;
			for(int j =0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int index = 0;
		int max = 0;
        for (int i = 0; i < n; i++) {
            if(max<dp[i]) {
            	max = dp[i];
            	index = i;
            }
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder();
        
		for(int i= index;i>=0;i--) {
			if(dp[i] == max) {
				sb.insert(0, arr[i]+" ");
				max--;
			}
			
		}
		System.out.print(sb.toString().trim());
	}
}
