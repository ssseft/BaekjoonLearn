package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B1806 {
	static int right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>=s) {
				System.out.println(1);
				return;
			}
		}
		
		right = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0;i<n;i++) {
			while(sum<s&&right<n) {
				sum+=arr[right++];
			}
			if(sum>=s) {
				min = Math.min(min, right-i);
			}
			sum-=arr[i];
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else{
			System.out.println(min);
		}
	}
}
