import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[100001];
		for(int i = 0;i<n;i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		long mod = 1_000_000_007;
		
		long[] add = new long[100001];
		for(int i = 1;i<100001;i++) {
			add[i] = add[i-1]+arr[i]*i;
		}
		
		long total = 0;
		for(int i = 2;i<100000;i++) {
			long temp = add[i-1]*(arr[i]*i)%mod;
			temp = (temp*(add[100000]-add[i]))%mod;
			total += temp;
			total%=mod;
		}
		
		
		System.out.print(total);
	}
}
