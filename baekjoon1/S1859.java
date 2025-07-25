package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1859 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ;i<t;i++) {
			long score = 0;
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int j = 0; j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int max = arr[n-1];
			for(int j = n-2;j>=0;j--) {
				if(max<arr[j]) {
					max = arr[j];
				}
				else {
					score += max-arr[j];
				}
			}
			sb.append("#"+(i+1)+" "+score+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
