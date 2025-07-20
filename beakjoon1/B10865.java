package beakjoon1;

import java.util.Scanner;

public class B10865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n+1];
		
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sc.nextLine();
			arr[a]++;
			arr[b]++;
		}
		for(int i =1;i<n+1;i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
