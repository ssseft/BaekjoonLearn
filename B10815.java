package beakjun;
import java.util.Scanner;
import java.util.Arrays;

public class B10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr1[] = new int[n];
		for(int i = 0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		
		int arr2[] = new int[m];
		for(int i = 0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr1);
		
		for(int i = 0; i<m; i++) {
			System.out.print(binarySearch(arr1, n, arr2[i])+" ");
		}
		
		
		
		
		
	}
	
	public static int binarySearch(int[] arr, int n, int search) {
		int first = 0;
		int last = n-1;
		int mid = 0;
		
		while(first<= last) {
			mid = (first+last)/2;
			
			if(arr[mid] == search) {
				return 1;
			}
			else if(arr[mid] < search) {
				first = mid+1;
			}
			else {
				last = mid -1;
			}
		}
		return 0;
		
	}
}
