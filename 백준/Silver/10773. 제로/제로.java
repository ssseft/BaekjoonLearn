import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		int sum = 0;
		for(int i = 0; i<n; i++) {
			int input = sc.nextInt();
			if(input == 0) {
				stack.pop();
				count++;
			}
			else {
				stack.push(input);
			}
		}
		sc.close();
		for(int i = 0; i<n-2*count; i++) {
			sum += stack.pop();
		}
		System.out.print(sum);
		
	}
}