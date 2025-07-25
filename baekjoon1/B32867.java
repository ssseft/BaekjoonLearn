package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B32867 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 1;i<n;i++) {
			int c = arr[i];
			if(max<c) {
				max = c;
			}
			else if(c<min) {
				min = c;
			}
			
			if(max - min>=k) {
				max = c;
				min = c;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
