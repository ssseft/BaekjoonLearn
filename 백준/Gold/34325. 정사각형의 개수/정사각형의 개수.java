import java.util.Scanner;

public class Main {
	static long mod = 1_000_000_007;
	static long powmod(long base, long p) {
        long r = 1 % mod;
        base %= mod;
        while (p > 0) {
            if ((p & 1) == 1) r = (r * base) % mod;
            base = (base * base) % mod;
            p >>= 1;
        }
        return r;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long k = sc.nextInt();
		long ans = 0;
		long das = 1;
		for (long i = 1; i <= n; i++) { 
			das = (das * (k % mod)) % mod; 
		}
        long invK = powmod(k, mod - 2);
		
		
		long past = 0;
		for(long i = 1;i<=n;i++) {
			long a = i*i;
			
			
			if(i%2==0) {
				long as = past-1;
				a+=as;
			}
			else {
				long as = past;
				a+=as;
			}
            
			a%=mod;
			a = (a*das)%mod;
			ans+=a;
			ans %=mod;
			past = i*i;
			das = (das * invK) % mod;
		}
		System.out.print(ans%mod);
	}
}