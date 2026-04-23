import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String A = sc.nextLine();
			boolean equal = true;
			if(A.equals(".")) {
				break;
			}
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i<A.length();i++) {
				if(A.charAt(i) == '('|| A.charAt(i) == '[') {
					stack.push(A.charAt(i));
				}
				else if(A.charAt(i) == ')' || A.charAt(i) == ']'){
					if(stack.empty()) {
						equal = false;
						break;
					}
					char top = stack.pop();
					if((A.charAt(i)== ')'&& top !='(')|| (A.charAt(i)== ']'&& top !='[')) {
						equal = false;
						break;
					}
				}
			}
			if (equal && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
		}
	}
}
