import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> q2 = new PriorityQueue<>();
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			q.clear();
			q2.clear();
			int mid = Integer.parseInt(st.nextToken());
			sb.append(n/2+1+"\n");
			sb.append(mid+" ");
			for(int i = 2;i<n+1;i++) {
				int c = Integer.parseInt(st.nextToken());
				if(i%10==0) {
					st = new StringTokenizer(br.readLine());
				}
				if(i%20==0) {
					sb.append("\n");
				}
				if(c>mid) q2.add(c);
				else q.add(c);
				if(i%2==1) {
					if(q.size()==q2.size()) {
						
					}
					else if(q.size()>q2.size()) {
						int temp = q.poll();
						q2.add(mid);
						mid = temp;
					}
					else {
						int temp = q2.poll();
						q.add(mid);
						mid = temp;
					}
					sb.append(mid+" ");
				}
				
			}
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}
