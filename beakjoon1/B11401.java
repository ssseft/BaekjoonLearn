package beakjoon1;

import java.util.Scanner;

public class B11401 {
	static long mod = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		long[] factorial = new long[n+1];
		factorial[0] = 1;
		for(int i = 1;i<=n;i++) {
			factorial[i] = (factorial[i-1]*i)%mod;
		}
		
		long denominator = (factorial[k]*factorial[n-k])%mod;
		
		long a = 1;
		long exp = mod-2;
		while(exp>0) {
			if((exp)%2==1){
				a = (a*denominator)%mod;
			}
			denominator = (denominator*denominator)%mod;
			exp /= 2;
		}
		
		long result = (a*factorial[n])%mod;
		System.out.print(result);
	}
}
