import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		for(int i = 0;i<n;i++) {
			arr[i] = br.readLine();
		}
		
		int k = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[1<<n][k];
		//비트마스킹을 사용한 숫자를 사용했을때 나머지가 r인 경우의 수
		
		int[] p = new int[51];
		p[0] = 1%k;
		for(int i = 1;i<51;i++) {
			p[i] = (int)((p[i-1]*10)%k);
		}
		
		int[] r = new int[n];
		for(int i =0;i<n;i++) {
			int total = 0;
			for(int j = 0;j<arr[i].length();j++) {
				total = (total*10+arr[i].charAt(j)-'0')%k;
			}
			r[i] = total;
		}
		
		dp[0][0]=1;
		
		for(int i = 0;i<(1<<n);i++) {
			for(int j = 0;j<k;j++) {
				long c = dp[i][j];
		        if(c==0) continue;
				for(int u = 0;u<n;u++) {
					if((i&(1<<u))==(1<<u)) continue;
		            int next = (int)((j*p[arr[u].length()]+ r[u]) % k);
		            dp[i|(1<<u)][next] += c;
				}
			}
		}
		long gcd = gcd(dp[(1<<n)-1][0],factorial(n));
		long ansp = dp[(1<<n)-1][0]/gcd;
		long ansc = factorial(n)/gcd;
		System.out.print(ansp+"/"+ansc);
	}
	static long factorial(int a) {
		long t = 1;
		for(int i =2;i<=a;i++) {
			t*=i;
		}
		return t;
	}
	static long gcd(long a,long b) { //무조건 b가 크거나 같음
		while(b!=0) {
	        long t =a%b;
	        a = b;
	        b = t;
	    }
		return a;
	}
}
