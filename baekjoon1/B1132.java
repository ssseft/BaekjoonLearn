package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1132 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		for(int i = 0; i<n;i++) {
			arr[i] = br.readLine();
		}
		boolean[] zero = new boolean[10];
		int[][] count = new int[12][10];
		// 12자리, 10개의 수  ex)1번쨰 자리에 8이 8개 있으면 count[1][8] = 8
		
		for(int i = 0; i<n;i++) {
			int size = arr[i].length();
			for(int j = 1; j<=size;j++) {
				int c = arr[i].charAt(size-j)-'A';
				count[j-1][c]++;
				if(j==size) zero[c] = true;
			}
		}
		long[] add = new long[10];
		for(int i = 0;i<12;i++) {
			for(int j =0;j<10;j++) {
				add[j] += (long)Math.pow(10, i)*count[i][j];
			}
		}
		
		Integer[] idx = new Integer[10];
		for(int i =0 ;i<10;i++) idx[i] = i;
		
		Arrays.sort(idx,(a,b)->Long.compare(add[b], add[a]));
		
		
		
		int[] result = new int[10];
		Arrays.fill(result, -1);
		int index = 9;
		boolean[] used = new boolean[10];
		
		//0 삽입
		for(int i = 9;i>=0;i--) {
			if(!zero[idx[i]]) {
				result[idx[i]] = 0;
				used[0] = true;
				break;
			}
		}
		
		//다른 수 모두 삽입
		for(int i = 0;i<10;i++) {
			if(result[idx[i]]!=0) {
				result[idx[i]] = index;
				used[index--] = true;
			}
		}
		
		long total = 0;
		for(int i = 0;i<n;i++) {
			long c = 0;
			for(int j =0;j<arr[i].length();j++) {
				c = c*10+result[arr[i].charAt(j)-'A'];
			}
			total+= c;
		}
		System.out.println(total);
		
	}
}
