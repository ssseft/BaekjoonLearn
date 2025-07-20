package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = Integer.MIN_VALUE;
		
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x,y});
		}
		int total = 0;
		int[] c = list.get(0);
		for(int i = 1;i<n;i++) {
			int[] next = list.get(i);
			total += (Math.abs(c[0]-next[0]) + Math.abs(c[1]-next[1]));
			c = next;
		}
		
		for(int i = 1;i<n-1;i++) {
			int[] prev = list.get(i-1);
			int[] cur = list.get(i);
			int[] next = list.get(i+1);
			
			int dis1 = (Math.abs(prev[0]-next[0]) + Math.abs(prev[1]-next[1]));
			int dis2 = (Math.abs(prev[0]-cur[0]) + Math.abs(prev[1]-cur[1]))+(Math.abs(cur[0]-next[0]) + Math.abs(cur[1]-next[1]));
			
			max = Math.max(max, dis2-dis1);
		}
		System.out.print(total-max);
		
	}
}
