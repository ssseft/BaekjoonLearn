package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B9084 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int j = 0; j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int goal = Integer.parseInt(br.readLine());
			int[] dp = new int[goal+1];
			dp[0] = 1;
			for (int j = 0; j < n; j++) {
                for (int k = 1; k <=goal; k++) {
                    if (k - arr[j] > 0) {
                        dp[k] = dp[k] + dp[k-arr[j]];
                    } else if (k - arr[j] == 0) {
                        dp[k]++;
                    }
                }
            }
			sb.append(dp[goal]+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
