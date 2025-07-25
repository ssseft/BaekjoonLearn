package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		arr[0] = Integer.parseInt(st.nextToken());
		if(n==1) {
			if(arr[0]==0) System.out.print("SAD");
			else System.out.print(arr[0]);
			return;
		}
		
		for(int i = 1;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			arr[i] = c+arr[i-1];
		}
		
		int max = arr[x-1];
		int cnt = 1;
		for(int i = x;i<n;i++) {
			int value = arr[i]-arr[i-x];
			if(max>value) {
				continue;
			}
			if(max==value) {
				cnt++;
			}
			else {
				max = value;
				cnt = 1;
			}
		}
		
		if(max==0) {
			System.out.print("SAD");
			return;
		}
		System.out.println(max);
		System.out.print(cnt);
	}
}
