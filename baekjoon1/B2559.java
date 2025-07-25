package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<k;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		if(max<sum) {
			max = sum;
		}
		for(int i = 0; i<n-k;i++) {
			arr[i+k] = Integer.parseInt(st.nextToken());
			sum += (arr[i+k]-arr[i]);
			if(sum>max) {
				max = sum;
			}
		}
		System.out.print(max);
	}
}
