package beakjoon1;
import java.util.Scanner;
import java.util.Stack;

public class B2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parentheses = sc.next();
		sc.close();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<parentheses.length();i++) {
			char current = parentheses.charAt(i);
			if(current=='('||current=='[') {
				stack.push((current=='(') ? -1:-2);
			}
			else {
				int value = 0;
				while (!stack.isEmpty()&&stack.peek()>0) {
                    value += stack.pop();
                }
				if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
				
				int last = stack.pop();
				
				if(last==-1) {
					if(current==')') {
						if(value==0) value = 2;
						
						else {
							value *=2;
						}
					}
					else {
						System.out.println(0);
						return;
					}
				}
				else {
					if(current==']') {
						if(value==0) {
							value = 3;
						}
						else {
							value *=3;
						}
					}
					else {
						System.out.println(0);
						return;
					}
				}
				stack.push(value);
			}
		}
		int result = 0;
		while(!stack.isEmpty()) {
			if(stack.peek()<0) {
				System.out.println(0);
				return;
			}
			else {
				result+=stack.pop();
			}
		}
		System.out.println(result);
	}
}