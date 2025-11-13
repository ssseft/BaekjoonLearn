import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long mod = 1_000_000_007L;
		long[] pow2 = new long[n];
		pow2[0] = 1;
		for(int i = 1;i<n;i++) {
		    pow2[i] = (pow2[i-1]*2)%mod;
		}
		
		long sum1 = 0;
		long sum2 = 0;
		for(int i = 0;i<n;i++) {
			sum1 += pow2[n-1-i]*arr[i];
			sum1 %= mod;
			
			sum2 += pow2[i]*arr[i];
			sum2 %= mod;
		}
		if(sum2<sum1) {
			sum2 += mod;
		}
		System.out.print(sum2-sum1);
	}
}
