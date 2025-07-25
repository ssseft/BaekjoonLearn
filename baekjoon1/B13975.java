package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Long> q;
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			q = new PriorityQueue<Long>();
			long sum = 0;
			for(int i = 0;i<n;i++) {
				q.add(Long.parseLong(st.nextToken()));
			}
			while(q.size()!=1) {
				long a = q.poll();
				long b = q.poll();
				q.add(a+b);
				sum+=(a+b);
			}
			sb.append(sum).append("\n");
			
		}
		System.out.print(sb.toString().trim());
		
	}
}
