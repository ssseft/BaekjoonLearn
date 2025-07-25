package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->b[1]-a[1]);
		int s = Integer.parseInt(br.readLine());
		int a = s;
		for(int i = 2;i<=n;i++) {
			int c = Integer.parseInt(br.readLine());
			q.add(new int[] {i,c});
		}
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[1]<s) break;
			
			s++;
			if(c[1]>1) {
				q.add(new int[] {c[0],c[1]-1});
			}
		}
		System.out.println(s-a);
	}
}
