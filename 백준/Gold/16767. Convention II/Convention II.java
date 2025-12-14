import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] startTime = new int[n];
		int[] endTime = new int[n];
		int max = 0;
		PriorityQueue<int[]> seq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			startTime[i] = a;
			seq.add(new int[] {a,b,i});
		}
		int curtime = seq.peek()[0];
		
		while(true) {
			while(true){
				if(!seq.isEmpty()&&seq.peek()[0]<=curtime) {
					int[] c = seq.poll();
					q.add(new int[] {c[1],c[2]});
				}
				else{
					if(q.isEmpty()&&!seq.isEmpty()) {
						curtime = seq.peek()[0];
						continue;
					}
					else break;
				}
			}
			
			if(q.isEmpty()) break;
			int[] cur = q.poll();
			int idx = cur[1];
			endTime[idx] = curtime;
			curtime += cur[0];
			
		}
		
		for(int i = 0;i<n;i++) {
			max = Math.max(endTime[i]-startTime[i], max);
		}
		System.out.print(max);
	}
}
