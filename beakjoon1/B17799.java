package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());		
		int c = Integer.parseInt(st.nextToken());		
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		int cnt = 0;
		
		while(left<=right) {
			if(arr[left]+arr[right]<=c) left++;
			right--;
			cnt++;
		}
		System.out.print(cnt);
	}
}
