package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1466 {
	static class node implements Comparable<node>{
		int end, value;
		
		node(int end, int value){
			this.end = end;
			this.value = value;
		}
		
		public int compareTo(node o) {
			return value-o.value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		List<node>[] list = new ArrayList[d+1];
		for (int i = 0; i <= d; i++) {
            list[i] = new ArrayList<>();
        }
		int[] dp = new int[d+1];
		Arrays.fill(dp, 1111111);
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(end-start>cost&&end<=d) {
				list[start].add(new node(end,cost));
			}
		}
		
		PriorityQueue<node> q = new PriorityQueue<>();
		q.add(new node(0,0));
		dp[0] = 0;
		
		while(!q.isEmpty()) {
			node current = q.poll();
			int curpos = current.end;
			int curvalue = current.value;
			
			if(curvalue>dp[curpos]) continue;
			
			if(curpos+1<=d&&curvalue+1<dp[curpos+1]) {
				dp[curpos+1] = curvalue+1;
				q.add(new node(curpos+1,curvalue+1));
			}
			
			for(node Node : list[curpos]) {
				int nextpos = Node.end;
				int nextvalue = curvalue+Node.value;
				if(nextvalue<dp[nextpos]) {
					dp[nextpos] = nextvalue;
					q.add(new node(nextpos,nextvalue));
				}
			}
		}
		System.out.print(dp[d]);
	}
}
