import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Integer> nums;
	static List<Character> oper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		
		nums = new ArrayList<>();
		oper = new ArrayList<>();
		
		for(int i = 0; i<n;i++) {
			if(word.charAt(i)>='0'&&word.charAt(i)<='9') {
				nums.add(word.charAt(i)-'0');
			}
			else {
				oper.add(word.charAt(i));
			}
		}
		
		int max = result(0, nums.get(0));
		System.out.println(max);
	}
	public static int cal(char op, int a, int b) {
		if(op=='+') {
			return a+b;
		}
		else if(op=='-') {
			return a-b;
		}
		else {
			return a*b;
		}
	}
	public static int result(int index, int currentscore) {
		if(index>=oper.size()) {
			return currentscore;
		}
		
		int result = cal(oper.get(index),currentscore,nums.get(index+1));
		int max = result(index+1,result);
		
		if(index+1<oper.size()) {
			int nextbracket = cal(oper.get(index+1),nums.get(index+1),nums.get(index+2));
			int result2 = cal(oper.get(index),currentscore,nextbracket);
			max = Math.max(max, result(index+2,result2));
		}
		return max;
	}
}