import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class room implements Comparable<room>{

		int start, end;
		public room(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(room r) {
			if(this.start == r.start) {
				return this.end - r.end;
			}
			return this.start-r.start;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int result= 0;
		room[] rooms = new room[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			rooms[i] = new room(s,t);
		}
		Arrays.sort(rooms);
		q.add(rooms[0].end);
		result++;
		for(int i =1; i<n;i++) {
			int t = q.poll();
			if(t>rooms[i].start) {
				q.add(t);
				result++;
			}
			q.add(rooms[i].end);
		}
		System.out.print(result);
		
	}
}