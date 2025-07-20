package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B25381 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int cnt = 0;
		
		List<Integer> list = new ArrayList<>();
		
		
		for(int i = 0;i<S.length();i++) {
			if(S.charAt(i)-'A'==1) {
				list.add(i);
			}
		}
		int idx = list.size()-1;
		for(int i = 0;i<S.length();i++) {
			if(S.charAt(i)-'A'==0) {
				int remidx = list.get(idx);
				if(i<remidx) {
					list.remove(idx--);
					cnt++;
				}
			}
		}
		int idx2 = 0;
		for(int i = S.length()-1;i>=0;i--) {
			if(S.charAt(i)-'A'==2) {
				int remidx = list.get(idx);
				if(i>remidx) {
					list.remove(idx++);
					cnt++;
				}
			}
		}
		
		
		System.out.print(cnt);
	}
}	
