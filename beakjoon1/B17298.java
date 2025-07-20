package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i = 1; i<=n;i++) {
			int c = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()&&stack.peek()[0]<c) {
				int[] current = stack.pop();
				arr[current[1]] = c;
			}
			stack.push(new int[]{c,i});
		}
		
		for(int i = 1; i<=n;i++) {
			if(arr[i] == 0 ) {
				sb.append(-1+" ");
			}
			else {
				sb.append(arr[i]+" ");
			}
		}
		System.out.println(sb.toString().trim());
	}
}