package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[53][53];
		//abce~~~ABCD~~Z
		List<Integer>[] list = new ArrayList[53];
		for(int i = 0;i<53;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = atoi(st.nextToken().charAt(0));
			int end = atoi(st.nextToken().charAt(0));
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start][end] += cost;
			arr[end][start] += cost;
			list[start].add(end);
			list[end].add(start);
		}
		
		int total = 0;
		
		while(true) {
			int[] parent = new int[53];
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			parent[1] = 1;
			
			while(!q.isEmpty()&&parent[25]==-1) {
				int c = q.poll();
				
				
				
			}
			
		}
		
	}
	static int atoi(char c) {
		if('A'<=c&&c<='Z') return c-'A';
		else {
			return c-103;
		}
	}
}
