package beakjoon1;

import java.util.Arrays;
import java.util.Scanner;

public class B20300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long max = 0;
		if(n%2==1) {
			max = arr[n-1];
			n--;
		}
		
		for(int i = 0;i<n/2;i++) {
			long a = arr[i];
			long b = arr[n-1-i];
			if(i==n-i) break;
			max = Math.max(max, a+b);
		}
		System.out.print(max);
	}
}
