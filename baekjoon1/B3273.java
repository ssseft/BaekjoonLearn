package beakjoon1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int x = Integer.parseInt(br.readLine());
		int left = 0;
		int right = n-1;
		int cnt = 0;
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(sum==x) {
				cnt++;
				left++;
				right--;
			}
			else if(sum>x) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.print(cnt);
	}
}
