import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[m];
		nums = new int[n];
		for(int i =0; i<n;i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		com(n,m,0,0);
		
		sc.close();
	}
	
	public static void com(int n, int m,int des,int start) {
		if(des == m) {
			for(int i : arr) {
				if(i ==0) {
					break;
				}
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<n;i++) {
			arr[des] = nums[i];
			com(n,m,des+1,i);
		}
	}
}