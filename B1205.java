package beakjun;
import java.util.Scanner;

public class B1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int score = sc.nextInt();
		int p = sc.nextInt();
		int[] arr = new int[n];
		if(n==0) {
			System.out.print(1);
			return;
		}
		int[] result = new int[p];
		for(int i =0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
	}
}
