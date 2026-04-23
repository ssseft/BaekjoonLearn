import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[n+1];
		int degree[] = new int[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			degree[next]++; 
			list[cur].add(next);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1;i<=n;i++) {
			if(degree[i]==0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int c = pq.poll();
			sb.append(c+" ");
			for(int nex : list[c]) {
				degree[nex]--;
				if(degree[nex]==0) {
					pq.add(nex);
				}
			}
		}
		
		System.out.print(sb.toString());
	}
}