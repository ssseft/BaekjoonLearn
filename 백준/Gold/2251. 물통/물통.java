import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		boolean[][][] visited = new boolean[a+1][b+1][c+1];
		Queue<int[]> q = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		q.add(new int[] {0,0,c});
		visited[0][0][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==0) list.add(cur[2]);
			int ca = cur[0];
			int cb = cur[1];
			int cc = cur[2];
			int temp = 0;
			// a -> b
			temp = cb+ca>=b ? b-cb : ca;
			if(!visited[ca-temp][cb+temp][cc]) {
				visited[ca-temp][cb+temp][cc] = true;
				q.add(new int[] {ca-temp,cb+temp,cc});
			}
			
			// a -> c
			temp = ca+cc>=c ? c-cc : ca;
			if(!visited[ca-temp][cb][cc+temp]) {
				visited[ca-temp][cb][cc+temp] = true;
				q.add(new int[] {ca-temp,cb,cc+temp});
			}
			
			// b -> c
			temp = cb+cc>=c ? c-cc : cb;
			if(!visited[ca][cb-temp][cc+temp]) {
				visited[ca][cb-temp][cc+temp] = true;
				q.add(new int[] {ca,cb-temp,cc+temp});
			}
			
			// b -> a
			temp = cb+ca>=a ? a-ca : cb;
			if(!visited[ca+temp][cb-temp][cc]) {
				visited[ca+temp][cb-temp][cc] = true;
				q.add(new int[] {ca+temp,cb-temp,cc});
			}
			
			// c -> a
			temp = cc+ca>=a ? a-ca : cc;
			if(!visited[ca+temp][cb][cc-temp]) {
				visited[ca+temp][cb][cc-temp] = true;
				q.add(new int[] {ca+temp,cb,cc-temp});
			}
			
			// c -> b
			temp = cc+cb>=b ? b-cb : cc;
			if(!visited[ca][cb+temp][cc-temp]) {
				visited[ca][cb+temp][cc-temp] = true;
				q.add(new int[] {ca,cb+temp,cc-temp});
			}
		}
		Collections.sort(list);
		for(int i : list) {
			System.out.print(i+" ");
		}
		
	}
}
