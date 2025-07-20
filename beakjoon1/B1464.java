package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B1464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		Deque<Integer> d = new ArrayDeque<>();
		d.add(word.charAt(0)-'A');
		for(int i = 1;i<word.length();i++) {
			int c = word.charAt(i)-'A';
			if(d.peekFirst()>=c) {
				d.addFirst(c);
			}
			else {
				d.addLast(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<word.length();i++) {
			sb.append((char)(d.pollFirst()+'A'));
		}
		
		System.out.print(sb.toString());
		
	}
}
