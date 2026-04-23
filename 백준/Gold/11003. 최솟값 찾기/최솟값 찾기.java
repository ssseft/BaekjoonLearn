import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Deque<int[]> d = new ArrayDeque<>();
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=  0;i<n;i++) {
			int c=  Integer.parseInt(st.nextToken());
			
			while(!d.isEmpty()&&d.getLast()[0]>=c) {
				d.removeLast();
			}
			while(!d.isEmpty()&&d.getFirst()[1]<=i-l) {
				d.removeFirst();
			}
			d.add(new int[] {c,i});
			sb.append(d.getFirst()[0]+" ");
		}
	
		System.out.println(sb);
	}
}