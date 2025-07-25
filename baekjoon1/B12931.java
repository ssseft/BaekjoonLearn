package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			arr[i] = Integer.toBinaryString(c);
			for(int j = 0;j<arr[i].length();j++) {
				if(arr[i].charAt(j)=='1') cnt++;
			}
			max = Math.max(max, arr[i].length());
		}
		
		System.out.print(max+cnt-1);
	}
}
