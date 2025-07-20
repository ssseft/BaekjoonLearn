package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2230 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<n;i++) {
			int c = Integer.parseInt(br.readLine());
			list.add(c);
		}
		Collections.sort(list);
		
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		
		while(right<list.size()) {
			int cal = list.get(right)-list.get(left);
			if(cal>=m) {
				min = Math.min(min, cal);
				left++;
				
			}
			else {
				right++;
			}
			if(left>right) {
				right = left;
			}
		}
		System.out.print(min);
	}
}
