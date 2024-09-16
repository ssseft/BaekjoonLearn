package beakjun;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class B1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		int index = 0;
		boolean check = false;
		for(int i =0; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]<0) {
				index++;
			}
			if(arr[i]==0) {
				check = true;
			}
		}
		Arrays.sort(arr,Collections.reverseOrder());
		if(check&&index%2==1) {
			arr[arr.length-index] = 0;
		}
		for(int i = 0;i<arr.length-1-index;i++) {
			if(arr[i+1]+arr[i]<arr[i]*arr[i+1]) {
				int a = arr[i];
				arr[i] = 0;
				arr[i+1] = a*arr[i+1];
				i++;
			}
		}
		int count = 0;
		for(int i =0;i<index/2;i++) {
			arr[arr.length-1-count] = arr[arr.length-1-count]*arr[arr.length-2-count];
			arr[arr.length-2-count] = 0;
			count+=2;
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			result+=arr[i];
		}
		System.out.print(result);
	}
}
