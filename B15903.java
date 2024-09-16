package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> q = new PriorityQueue<>();
		for(int i =0; i<n;i++) {
			q.add(Long.parseLong(st.nextToken()));
		}
		for(int i =0; i<m;i++) {
			long num1 = q.poll();
			long num2 = q.poll();
			q.add(num1+num2);
			q.add(num1+num2);
		}
		long result =0;
		while(!q.isEmpty()) {
			result += q.poll();
		}
		System.out.print(result);
	}
}
