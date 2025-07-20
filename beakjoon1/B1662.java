package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B1662 {
	static String line;
	static List<Integer> list;
	static int index = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		list = new ArrayList<>();
		for(int i = 0;i<line.length();i++) {
			if(line.charAt(i)==')') list.add(i);
		}
		System.out.println(recursion(0));
	}
	static int recursion(int idx){
		int cnt = 0;
		Stack<Character> st = new Stack<>();
		for(int i = idx;i<line.length();i++) {
			char c = line.charAt(i);
			if(c!='('&&c!=')'){
				st.add(c);
				cnt++;
			}
			else {
				if(c=='(') {
					int s = st.pop()-'0';
					cnt--;
					cnt += s*(recursion(i+1));
					i = list.get(index++);
				}
				else {
					return cnt;
				}
			}
		}
		return cnt;
	}
}
