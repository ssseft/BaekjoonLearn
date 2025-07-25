package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String boom = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<word.length();i++) {
			stack.push(word.charAt(i));
			
			if(stack.size()>=boom.length()) {
				boolean delete = true;
				for(int j = 0; j<boom.length();j++) {
					if(stack.get(stack.size() - boom.length() + j) != boom.charAt(j)){
						delete = false; 
						break;
					}
				}
				if(delete) {
					for(int j = 0; j<boom.length();j++) {
						stack.pop();
					}
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (char ch : stack){
			sb.append(ch);
		}
		
		System.out.print(sb.length()==0 ? "FRULA" : sb.toString());
	}
}
