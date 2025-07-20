package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18185 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int one = 0, two = 0, three = 0;
		
		for(int i = 0;i<n-2;i++) {
			int a1 = list.get(i);
			int a2 = list.get(i+1);
			int a3 = list.get(i+2);
			if(a1==0) continue;
			if(a2==0) {
				one += a1;
				i++;
				continue;
			}
			if(a3==0) {
				int min = Math.min(a1, a2);
				two += min;
				one += Math.max(a1, a2) - Math.min(a1, a2);
				continue;
			}
			else {
				int sum = a1+a2+a3;
				int fir = Math.max(a1, Math.max(a2, a3));
				int thi = Math.min(a1, Math.min(a2, a3));
				int sec = sum-fir-thi;
				three += thi;
				sec -= thi;
				fir -= thi;
				two += Math.min(sec, fir);
				one += Math.max(sec, fir) - Math.min(sec, fir);
			}
		}
		
		
		
		
		
		
	}
}
