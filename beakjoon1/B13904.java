package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->
		{
			if(a[1] ==b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			else {
				return Integer.compare(b[1], a[1]);
			}
		});
		int max = 0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			q.add(new int[] {day,score});
			if(day>max) {
				max = day;
			}
		}
		int cnt = 0;
		int[] result = new int[max+1];
		while(!q.isEmpty()) {
			int[] current = q.poll();
			for(int i = current[0];i>0;i--) {
				if(result[i]==0) {
					result[i] = current[1];
					cnt+= current[1];
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}