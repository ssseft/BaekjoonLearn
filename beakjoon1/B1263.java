package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1263 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[] {t,s});
		}
		
		Collections.sort(list,(a,b)->b[1]-a[1]);
		
		int idx = list.get(0)[1];
		
		for(int i = 0;i<list.size();i++) {
			int[] c = list.get(i);
			
			if(idx<=c[1]) {
				idx -= c[0];
			}
			else {
				idx = c[1]-c[0];
			}
		}
		
		
		if(idx<0) {
			System.out.print(-1);
		}
		else {
			System.out.println(idx);
		}
	}
}
