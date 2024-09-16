package beakjun;
import java.util.Scanner;

public class B1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int[] arr = new int[K];
		long max = 0;
		for(int i = 0; i<K; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		max++;
		
		long min =0;
		long mid =0;
		while(min<max) {
			
			long count = 0;
			mid = (min+max)/2;
			for(int i =0; i < arr.length; i++) {
				count += (arr[i]/mid);
			}
			if(count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		sc.close();
		System.out.println(min-1);
	}
}