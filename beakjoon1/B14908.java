package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B14908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[] {s,e,i});
		}
		
		Collections.sort(list,(a,b)->{
		    int l =  a[1]*b[0];
		    int r =  b[1]*a[0];
		    return Integer.compare(r,l);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int[] a : list) {
			sb.append(a[2]+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
