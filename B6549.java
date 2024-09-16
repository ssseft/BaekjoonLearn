package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B6549 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) {
				break;
			}
			int[] arr = new int[n];
			for(int i = 0; i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Stack<Integer> Stack = new Stack<>();
			int current = arr[0];
			Stack.add(0);
			int max = 0;
			for(int i =1; i<n;i++) {
				int num = arr[i];
				if(current<num) {
					Stack.add(i);
					current = arr[i];
				}
				else {
					while(true) {
						
						
						
						
						
					}
				}
			}
		}
	}
}
