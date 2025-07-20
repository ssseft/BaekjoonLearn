package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] degree = new int[n+1];
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i<=n;i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			degree[e]++;
			list.get(s).add(e);
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=n;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current+" ");
			for(int a : list.get(current)) {
				degree[a]--;
				if(degree[a] == 0) {
					q.add(a);
				}
			}
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
