package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		
		long min = Long.MAX_VALUE;
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		
		for(int i = 0;i<n-2;i++) {
			int left = i+1;
			int right = n-1;
			
			while(left<right) {
				long sum = arr[i]+arr[left]+arr[right];
				if(Math.abs(sum)<min) {
					min = Math.abs(sum);
					r1 = i;
					r2 = left;
					r3 = right;
				}
				if(sum<0) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		
		System.out.print(arr[r1]+" "+arr[r2]+" "+arr[r3]);
		
	}
}
