package beakjun;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class B1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int[] sequence = new int[n];
		Queue<String> arr = new LinkedList<>();
		
		for(int i = 0; i<n;i++) {
			sequence[i] = sc.nextInt();
		}
		sc.close();
		int index = 0;
		
		for(int i = 1; i<n+1; i++) {
			stack.push(i);
			arr.offer("+");
			while(!stack.isEmpty() && stack.peek() == sequence[index]) {
				stack.pop();
				arr.offer("-");
				index++;
			}
		}
		if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            while (!arr.isEmpty()) {
                System.out.println(arr.poll());
            }
        }
		
	}
}
