import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
		PriorityQueue<Integer> q2 = new PriorityQueue<>();
		
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(s<e) q.add(new int[] {s,e});
			else q.add(new int[] {e,s});
		}
		int d = Integer.parseInt(br.readLine());
		
		int max = 0;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curmax = c[1]-d;
			q2.add(c[0]);
			while(!q2.isEmpty()&&q2.peek()<curmax) {
				q2.poll();
			}
			max = Math.max(max, q2.size());
		}
		System.out.print(max);
		
		
	}
}
