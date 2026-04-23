import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Deque<Integer> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<n; i++) {
			String word = sc.next();
			
			if(word.equals("push_back")||word.equals("push_front")) {
				int num = sc.nextInt();
				if(word.equals("push_back")) {
					d.addLast(num);
				}
				else {
					d.addFirst(num);
				}
			}
			else if(word.equals("pop_front")){
				if(d.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(d.pollFirst()).append('\n');
				}
			}
			else if(word.equals("pop_back")) {
				if(d.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(d.pollLast()).append('\n');
				}
			}
			else if(word.equals("size")) {
				sb.append(d.size()).append('\n');
			}
			else if(word.equals("empty")) {
				if(d.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
			}
			else if(word.equals("front")) {
				if(d.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(d.getFirst()).append('\n');
				}
			}
			else if(word.equals("back")){
				if(d.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(d.getLast()).append('\n');
				}
			}
			
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
