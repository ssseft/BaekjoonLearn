package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i<N;i++) {
			arr[i] = (Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = 0; i<N;i++) {
			int c = arr[i];
			int left = 0;
			int right = N-1;
			while(left<right) {
				if(left==i) {
					left++;
					continue;
				}
				if(right ==i) {
					right--;
					continue;
				}
				int sum = arr[left]+arr[right];
				
				if(c==sum) {
					cnt++;
					left = 0; right = 0;
					
				}
				else if(c<sum) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		System.out.print(cnt);
		
	}
}
