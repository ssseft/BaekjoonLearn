package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2887 {
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
		
		List<int[]> x = new ArrayList<>();
		List<int[]> y = new ArrayList<>();
		List<int[]> z = new ArrayList<>();
		parent = new int[n];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int z1 = Integer.parseInt(st.nextToken());
			x.add(new int[] {x1,i});
			y.add(new int[] {y1,i});
			z.add(new int[] {z1,i});
			parent[i] = i;
		}
		
		Collections.sort(x,(a,b)->a[0]-b[0]);
		Collections.sort(y,(a,b)->a[0]-b[0]);
		Collections.sort(z,(a,b)->a[0]-b[0]);
		
		for(int i = 0;i<n-1;i++) {
			q.add(new int[] {x.get(i+1)[0]-x.get(i)[0],x.get(i)[1],x.get(i+1)[1]});
			q.add(new int[] {y.get(i+1)[0]-y.get(i)[0],y.get(i)[1],y.get(i+1)[1]});
			q.add(new int[] {z.get(i+1)[0]-z.get(i)[0],z.get(i)[1],z.get(i+1)[1]});
		}
		
		int sum = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(union(c[1],c[2])) sum+=c[0];
		}
		System.out.println(sum);
	}
}
