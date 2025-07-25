package beakjoon1;
import java.io.*;
import java.util.PriorityQueue;
public class B11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> {
			if(Math.abs(a)==Math.abs(b)) {
				return a-b;
			}
			else {
				return Math.abs(a)-Math.abs(b);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n;i++) {
			int c = Integer.parseInt(br.readLine());
			if(c==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(q.poll()+"\n");
				}
			}
			else {
				q.add(c);
			}
		}
		System.out.println(sb.toString().trim());
	}
}