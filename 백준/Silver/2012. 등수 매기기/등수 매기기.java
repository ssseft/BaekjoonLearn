import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		long sum = 0;
		
		for(int i =0; i<n; i++) {
			sum += Math.abs(arr[i]-(i+1));
		}
		
		System.out.print(sum);
	}
}
