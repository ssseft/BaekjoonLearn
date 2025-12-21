import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		for(int i = 0;i<n;i++) {
			sc.nextInt();
			int c = sc.nextInt();
			while(true) {
				if(stack.peek()<c) {
					stack.add(c);
					break;
				}
				else if(stack.peek()==c) break;
				else {
					ans++;
					stack.pop();
				}
			}
		}
		while(true) {
			if(stack.peek()==0) break;
			stack.pop();
			ans++;
		}
		System.out.println(ans);
	}
}
