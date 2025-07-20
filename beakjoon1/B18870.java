package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] {c,i});
		}
		Collections.sort(list,(a,b)->a[0]-b[0]);
		
		int[] result = new int[n];
		int idx = 0;
		int beforenumber = list.get(0)[0];
		
		for(int i = 0;i<n;i++) {
			int c = list.get(i)[0];
			int index = list.get(i)[1];
			if(beforenumber==c) {
				result[index] = idx;
			}
			else {
				result[index] = ++idx;
				beforenumber = c;
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			sb.append(result[i]+" ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
