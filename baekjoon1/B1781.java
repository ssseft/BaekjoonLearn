package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1781 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i<n;i++	) {
			st = new StringTokenizer(br.readLine());
			int d_day = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			list.add(new int[] {d_day,num});
		}
		list.sort((a,b) ->Integer.compare(a[0], b[0]));
		int sum = 0;
		for(int i = 0; i<n;i++) {
			int[] current = list.get(i);
			q.add(current[1]);
			if(q.size()>current[0]) {
				q.poll();
			}
		}
		while(!q.isEmpty()) {
			sum+= q.poll();
		}
		System.out.println(sum);
	}
}
