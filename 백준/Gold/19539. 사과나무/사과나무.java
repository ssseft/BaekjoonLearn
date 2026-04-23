import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int max = -1;
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int one = 0,two = 0;
		for(int i = 0;i<n;i++) {
			one+=arr[i]%2;
			two+=arr[i]/2;
		}
		
		
		if(one>two) {
			System.out.print("NO");
		}
		else if(one==two) {
			System.out.print("YES");
		}
		else {
			while(Math.abs(two-one)>1) {
				two--;
				one+=2;
			}
			if(one==two) {
				System.out.print("YES");
			}
			else {
				System.out.print("NO");
			}
		}
	}
}
