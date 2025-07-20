package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] up = new int[h+1];
		int[] down = new int[h+1];
		int[] result = new int[h+1];
		
		for(int i = 0;i <n/2;i++) {
			int u = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());
			up[u]++;
			down[d]++;
		}
		for(int i = h-1;i>=2;i--) {
			up[i-1] += up[i];
			down[i-1] += down[i];
		}
		
		for(int i = 1;i<h+1;i++) {
			result[i] += up[h-i];
			result[i-1] += down[i];
		}
		
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i = 0;i <h;i++) {
			if(min==result[i]) {
				cnt++;
			}
			if(min>result[i]) {
				cnt = 1;
				min = result[i];
			}
		}
		System.out.println(min+" "+cnt);
	}
}