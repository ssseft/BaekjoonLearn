import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long cnt = 0;
		
		for(long s = 1; s<=1500;s++) {
			if(k>b/s) break;
            long n = k*s;
            if (n < a) continue;

            long tmp = n;
            long sum = 0;
            while(tmp>0){
                long d = tmp%10;
                sum += d*d;
                tmp /= 10;
            }

            if(sum==s) cnt++;
        }

        System.out.print(cnt);
		
		
		
	}
}