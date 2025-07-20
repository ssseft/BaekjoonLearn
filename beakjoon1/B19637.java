package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19637 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		String[] name = new String[n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<m;i++) {
			int c = Integer.parseInt(br.readLine());
			int left = 0;
			int right = n-1;
			while(left<right) {
				int mid = (left+right)/2;
				if(arr[mid]>=c) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			if(arr[left]<c) {
				sb.append(name[left+1]+"\n");
			}
			else {
				sb.append(name[left]+"\n");
			}
		}
		System.out.println(sb);
	}
}
