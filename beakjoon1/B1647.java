package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1647 {
	static int[] parent;
	public static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);
		}
    }
	public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false;
        
        parent[rootY] = rootX;
        return true;
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> q= new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
		parent = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			q.add(new int[] {start,end,value});
		}
		
		int max = 0;
		int sum = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(union(c[0],c[1])) {
				max = Math.max(max, c[2]);
				sum+=c[2];
			}
		}
		
		System.out.println(sum-max);
	}
}
