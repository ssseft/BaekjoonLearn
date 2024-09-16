package beakjun;
import java.util.Scanner;

public class B2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		
		long max = 0;
		long min =0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		while(min<max) {
			long mid = (max+min)/2;
			long sum = 0;
			
			for(int i =0; i<arr.length; i++) {
				if(arr[i]-mid>0) {
				sum += (arr[i]-mid);
				}
			}
			
			if(sum<m) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		System.out.print(min-1);
		sc.close();
	}
}
