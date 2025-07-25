package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b,a));
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int dis = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new int[] {dis,size});
		}
		st = new StringTokenizer(br.readLine());
		int goal = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		list.sort((a,b)->Integer.compare(a[0], b[0]));
		int index = 0;
		int current = fuel;
		int cnt = 0;
		while(goal>current) {
			while(index<n&&current>=list.get(index)[0]) {
				q.add(list.get(index)[1]);
				index++;
			}
			if(q.isEmpty()) {
				System.out.println(-1);
				return;
			}
			cnt++;
			current+=q.poll();
			
		}
		System.out.println(cnt);
	}
}