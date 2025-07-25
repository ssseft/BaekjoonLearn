package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4716 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int Acnt = Integer.parseInt(st.nextToken());
			int Bcnt = Integer.parseInt(st.nextToken());
			int distance = 0;
			if(n==0) break;
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(Math.abs(b[1]-b[2]),Math.abs(a[1]-a[2])));
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int cnt = Integer.parseInt(st.nextToken());
				int ad = Integer.parseInt(st.nextToken());
				int bd = Integer.parseInt(st.nextToken());
				pq.add(new int[] {cnt,ad,bd});
			}
			while(!pq.isEmpty()) {
				int[] c = pq.poll();
				int cnt = c[0];
				int disA = c[1];
				int disB = c[2];
				if(disA<disB) {
					if(cnt<=Acnt) {
						Acnt -= cnt;
						distance += (cnt*disA);
					}
					else {
						cnt -= Acnt;
						distance += (Acnt*disA);
						Acnt = 0;
						distance += (cnt*disB);
						Bcnt -= cnt;
					}
				}
				else {
					if(cnt<=Bcnt) {
						Bcnt -= cnt;
						distance += (cnt*disB);
					}
					else {
						cnt -= Bcnt;
						distance += (Bcnt*disB);
						Bcnt = 0;
						distance += (cnt*disA);
						Acnt-= cnt;
					}
				}
				
			}
			
			
			sb.append(distance+"\n");
		}
		System.out.println(sb.toString().trim());
	}
}
