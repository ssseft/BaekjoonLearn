import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) System.out.print(1906);
		else if(n==3) System.out.print(2026);
		else {
			int[] arr = new int[n];
			arr[0] = 1;
			arr[n-1] = 1;
			arr[n/2] = 2;
			arr[n-1] += 5;
			arr[n-3] += 9;
			if(arr[n-3]>9) {
				arr[n-3] -= 10;
				arr[n-4]++;
			}
			arr[n-4]+=1;
			if(arr[n-4]>9) {
				arr[n-4] -= 10;
				arr[n-5]++;
			}
			StringBuilder sb = new StringBuilder();
			for(int a : arr) sb.append(a);
			System.out.println(sb);
		}
		
	}
}
