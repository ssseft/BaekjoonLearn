package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B6068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			q.add(new int[] {t,s});
		}
		
		int[] last = q.poll();
		int maxtime = last[1]-last[0];
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(maxtime<c[1]) maxtime -= c[0];
			else maxtime = c[1]-c[0];
		}
		
		if(maxtime<0) System.out.print(-1);
		else System.out.print(maxtime);
	}
}
