package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int cnt = 0;
		boolean[] oddvisited = new boolean[500001];
		boolean[] evenvisited = new boolean[500001];
		int[] odd = new int[500001];
		int[] even = new int[500001];
		oddvisited[n] = true;
		evenvisited[n] = true;
		odd[n] = 1;
		int movedistance = 0;
		if(n==goal) {
			System.out.print(0);
			return;
		}
		
		while(!q.isEmpty()) {
			int size =  q.size();
			goal+=movedistance++;
			if(goal>500000) break;
			if(cnt%2==0) {
				if(odd[goal]!=0) break;
			}
			else {
				if(even[goal]!=0) break;
			}
			
			for(int i = 0;i<size;i++) {
				int c = q.poll();
				if(cnt%2==1) {
					if(c+1<500001&&!oddvisited[c+1]) {
						q.add(c+1);
						oddvisited[c+1] = true;
						odd[c+1] = cnt+1;
					}
					if(c-1>0&&!oddvisited[c-1]) {
						q.add(c-1);
						oddvisited[c-1] = true;
						odd[c-1] = cnt+1;
					}
					if(c*2<500001&&!oddvisited[c*2]) {
						q.add(2*c);
						oddvisited[c*2]=  true;
						odd[2*c] = cnt+1;
					}
				}
				else {
					if(c+1<500001&&!evenvisited[c+1]) {
						q.add(c+1);
						evenvisited[c+1] = true;
						even[c+1] = cnt+1;
					}
					if(c-1>0&&!evenvisited[c-1]) {
						q.add(c-1);
						evenvisited[c-1] = true;
						even[c-1] = cnt+1;
					}
					if(c*2<500001&&!evenvisited[c*2]) {
						q.add(2*c);
						evenvisited[c*2]=  true;
						even[c*2] = cnt+1;
					}
				}
				
			}
			cnt++;
		}
		if(goal>500000) System.out.println(-1);
		else System.out.println(cnt);
	}
}
