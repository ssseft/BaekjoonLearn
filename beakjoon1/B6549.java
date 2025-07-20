package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B6549 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) {
				break;
			}
			long[] arr = new long[n];
			for(int i = 0;i<n;i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			long max = 0;
			Stack<long[]> stack = new Stack<>();
			long idx = 0;
			for(int i = 0;i<n;i++) {
				long c = arr[i];
				idx = i;
				if(!stack.isEmpty()&&c==stack.peek()[0]) continue;
				
				while(!stack.isEmpty()&&stack.peek()[0]>c) {
					long[] cur = stack.pop();
					max = Math.max(max, cur[0]*(i-cur[1]));
					idx = cur[1];
				}
				
				stack.add(new long[] {c,idx});
			}
			
			while(!stack.isEmpty()) {
				long[] cur = stack.pop();
				max = Math.max(max, cur[0]*(n-cur[1]));
			}
			
			sb.append(max+"\n");
			
		}
		System.out.print(sb.toString().trim());
	}
}
