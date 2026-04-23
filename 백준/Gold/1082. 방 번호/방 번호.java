import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int minvalue = 50;
		for(int i =0; i<n;i++) {
			arr[i] = sc.nextInt();
			if(arr[i]<minvalue) {
				minvalue = arr[i];
			}
		}
		int minnot0 = 50;
		for(int i =1; i<n;i++) {
			if(arr[i] < minnot0) {
				minnot0 = arr[i];
			}
		}
		int m = sc.nextInt();
		if(m-minnot0<0) {
			System.out.print(0);
			return;
		}
		int digits = 1 + (m - minnot0) / minvalue;
		int[] dp= new int[50];
		int a = digits;
		int index = 0;
		while(a>0) {
			for(int i = n-1;i>=0;i--) {
				if(minvalue*(a-1)>m-arr[i]) {
					continue;
				}
				else {
					m -= arr[i];
					dp[index] = i;
					a--;
					index++;
					break;
				}
			}
		}
		for(int i=0; i<digits;i++) {
			System.out.print(dp[i]);
		}
		
	}
}