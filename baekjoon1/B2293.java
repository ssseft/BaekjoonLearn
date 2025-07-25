package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		
		for(int i = 1; i<=n;i++) {
			int current = Integer.parseInt(br.readLine());
			if(current>k) continue;
			dp[current]+=1;
			for(int j = current+1;j<=k;j++) {
				dp[j]+= dp[j-current];
			}
		}
		
		System.out.println(dp[k]);
		
	}
}