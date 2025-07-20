package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B19598 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new int[] {start,end});
		}
		list.sort((a,b)-> Integer.compare(a[0], b[0]));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(list.get(0)[1]);
		for(int i = 1; i<n;i++) {
			int[] c = list.get(i);
			if(pq.peek()<=c[0]) {
				pq.poll();
			}
			pq.add(c[1]);	
		}
		
		System.out.println(pq.size());
	}
}
