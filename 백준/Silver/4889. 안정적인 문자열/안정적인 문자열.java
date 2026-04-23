import java.util.Stack;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		StringBuilder sb= new StringBuilder();
		int index = 1;
		while(true) {
			String S = br.readLine();
			if(S.charAt(0)== '-') {
				break;
			}
			for(int i =0; i<S.length();i++) {
				stack.push(String.valueOf(S.charAt(i)));
			}
			int left = 0;
			int right = 0;
			int count = 0;
			for(int i =0;i<S.length();i++) {
				String ch = stack.pop();
				if(ch.equals("{")) { 
					if(right !=0) {
						right--;
					}
					else {
						left++;
					}
				}
				else {
					right++;
				}
			}
			
			count+= (left+1)/2+(right+1)/2;
			
			
			sb.append(index+". "+count+"\n");
			index++;
			
		}
		System.out.print(sb.toString());
	}
}
