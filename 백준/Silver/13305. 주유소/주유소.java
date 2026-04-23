import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dis = new long[n-1];
		long[] mon = new long[n];
		
		for(int i= 0; i<n-1; i++) {
			dis[i] = sc.nextLong();
		}
		for(int i =0; i<n;i++){
			mon[i] = sc.nextLong();
		}
		sc.close();
		long min = mon[0];
		long sum = mon[0] * dis[0];
		
		for(int i =1; i<n-1; i++) {
			min = Math.min(min,mon[i]);
			sum += min*dis[i];
		}
		
		System.out.print(sum);
	}
}
