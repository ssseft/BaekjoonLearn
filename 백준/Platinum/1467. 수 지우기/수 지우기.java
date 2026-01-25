import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		char[] d = sc.nextLine().toCharArray();
		int[] numCnt = new int[10];
		int[] eraCnt = new int[10];
		for(int i = 0;i<arr.length;i++) 
			numCnt[arr[i]-'0']++;
		for(int i = 0;i<d.length;i++) 
			eraCnt[d[i]-'0']++;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0;i<arr.length;i++) {
			int c = arr[i]-'0';
			
			if(eraCnt[c]>0&&eraCnt[c]==numCnt[c]) {
				eraCnt[c]--;
				numCnt[c]--;
			}
			else {
				while(!stack.isEmpty()) {
					if(stack.peek()>=c||eraCnt[stack.peek()]==0) break;
					eraCnt[stack.peek()]--;
					stack.pop();
				}
				numCnt[c]--;
				stack.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		System.out.println(sb.reverse());
	}
}
