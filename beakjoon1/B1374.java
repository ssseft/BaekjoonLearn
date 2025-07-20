package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(Comparator.comparingInt(a->a[1]));
		PriorityQueue<Integer> ing = new PriorityQueue<>();
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			q.add(new int[] {num,start,end});
		}
		while(!q.isEmpty()) {
			int[] current = q.poll();
			if(!ing.isEmpty()&&ing.peek() <= current[1]) {
				ing.poll();
			}
			ing.add(current[2]);
		}
		System.out.println(ing.size());
	}
}
