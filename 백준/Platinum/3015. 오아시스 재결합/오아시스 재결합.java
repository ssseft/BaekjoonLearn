import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long ans = 0;
		Stack<int[]> stack = new Stack<>();
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(br.readLine());
			
			
			while(!stack.isEmpty()&&stack.peek()[0]<c) {
				int[] s = stack.pop();
				ans += s[1];
			}
			
			if(stack.isEmpty()) stack.add(new int[] {c,1});
			else {
				if(stack.peek()[0]==c) {
					int[] s = stack.pop();
					stack.add(new int[] {c,s[1]+1});
					ans += s[1];
				}
				else stack.add(new int[] {c,1});
				if(stack.size()>1)ans++;
			}
			
		}
		System.out.print(ans);
	}
}