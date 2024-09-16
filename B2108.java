package beakjun;
import java.util.Scanner;
import java.util.Arrays;

public class B2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		
		int[] arr = new int[A];
		int sum = 0;
		for(int i =0; i<A; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		sc.close();
		Arrays.sort(arr);
		int min = arr[0];
		int current = 0;
		int B = -1;
		boolean check = false;
		for (int i = 0; i < A-1; i++) {
            if (arr[i] == arr[i + 1]) {
                current++;
            } else {
            	current= 0;
            }
            
            if(current>B) {
            	B = current;
            	min = arr[i];
            	check = true;
            }
            else if(B==current&& check==true) {
            	min = arr[i];
            	check = false;
            }
		}
		
		System.out.println((int)Math.round((double)sum/A));
		System.out.println(arr[(A-1)/2]);
		System.out.println(min);
		System.out.println(arr[A-1]-arr[0]);
	}
}
