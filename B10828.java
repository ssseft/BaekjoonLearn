package beakjun;
import java.util.Scanner;
import java.util.Stack;

public class B10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while(n > 0) {
            String text = sc.next();
            if(text.equals("push")) {
                int num = sc.nextInt();
                stack.push(num);
            }
            else if(text.equals("pop")) {
                if(!stack.isEmpty()) {
                    int result = stack.pop();
                    System.out.println(result);
                } else {
                    System.out.println(-1);
                }
            }
            else if(text.equals("size")) {
                int result = stack.size();
                System.out.println(result);
            }
            else if(text.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            else if(text.equals("top")) { 
                if(!stack.isEmpty()) {
                    int result = stack.peek();
                    System.out.println(result);
                } else {
                    System.out.println(-1);
                }
            }
            n--;
        }
        sc.close();
    }
}
