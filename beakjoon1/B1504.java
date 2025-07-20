package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class B1504 {
	static class Node implements Comparable<Node>{
		int end;
		int value;
		public Node(int end,int value) {
			this.end= end;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return value-o.value;
		}
	}
	static List<Node>[] list;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 0; i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		
		for(int i = 0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,value));
			list[end].add(new Node(start,value));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		
		int one_to_v1 = dijkstra(1,v1);
		int v1_to_v2 = dijkstra(v1,v2);
		int v2_to_n = dijkstra(v2,n);
		int one_to_v2 = dijkstra(1,v2);
		int v2_to_v1 = dijkstra(v2,v1);
		int v1_to_n = dijkstra(v1,n);
		//System.out.println(one_to_v1+" "+v1_to_v2+" "+v2_to_n);
		//System.out.println(one_to_v2+" "+v2_to_v1+" "+v1_to_n);
		int result;
		if(one_to_v1==Integer.MAX_VALUE||v1_to_v2==Integer.MAX_VALUE||v2_to_n==Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		else {
			result = one_to_v1+v1_to_v2+v2_to_n;
		}
		if(one_to_v2==Integer.MAX_VALUE||v2_to_v1==Integer.MAX_VALUE||v1_to_n==Integer.MAX_VALUE) {
			
		}
		else {
			result = Math.min(one_to_v2+v2_to_v1+v1_to_n,result);
		}
		
		if(result==Integer.MAX_VALUE||result<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
		
	}
	static int dijkstra(int start,int goal) {
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		distance[start] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int current = cur.end;
			int dist = cur.value;
			if(distance[current]<dist) continue;
			
			for(Node node : list[current]) {
				int next = node.end;
				int d = dist+node.value;
				
				if(d<distance[next]) {
					distance[next] = d;
					q.add(new Node(next,d));
				}
			}
		}
		return distance[goal];
	}
}
