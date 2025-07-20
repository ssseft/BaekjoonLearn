package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					sb.append(0+" ");
					stack.add(new int[] {c,i+1});
					break;
				}
				
				if(stack.peek()[0]>c) {
					sb.append(stack.peek()[1]+" ");
					stack.add(new int[] {c,i+1});
					break;
				}
				else if(stack.peek()[0]==c) {
					sb.append(stack.peek()[1]+" ");
					stack.pop();
					stack.add(new int[] {c,i+1});
					break;
				}
				else {
					stack.pop();
				}
			}
		}
		System.out.println(sb.toString().trim());
		
	}
}
