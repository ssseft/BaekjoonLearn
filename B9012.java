package beakjun;
import java.util.*;


public class B9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		
		for(int i = 0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String line = sc.next();
			int ox = 0;
			for(int j =0; j<line.length(); j++) {
				char c = line.charAt(j);
				
				
				if(c == '(') {
					stack.push(c);
				}
				else if(stack.empty()) {
					ox++;
				}
				else {
					stack.pop();
				}
				
				
			}
			if(!stack.empty()) {
				ox++;
			}
			if(ox == 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
			
			
		}
		sc.close();
		
	}
}
