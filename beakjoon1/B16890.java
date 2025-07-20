package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B16890 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2 = br.readLine();
		
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		for(int i = 0;i<line1.length();i++) {
			list1.add(line1.charAt(i));
			list2.add(line2.charAt(i));
		}
		Collections.sort(list1);
		Collections.sort(list2 ,(a,b)->b-a);
		int cnt = 0;
		int idx1 =0;
		int idx2 =0;
		char[] arr = new char[line1.length()];
		
		while(cnt<line1.length()) {
			if(cnt%2==0) {
				if(list1.get(idx1)>=list2.get(idx2)) {
					int c = line1.length()-cnt;
					if(c%2==1) {
						for(int i = 0;i<c;i++) {
							if(i%2==0) {
								arr[cnt+i] = list1.get(idx1);
								idx1++;
							}
							else {
								arr[cnt+i] = list2.get(idx2);
								idx2++;
							}
						}
					}
					else {
						for(int i = 0;i<c;i++) {
							if(i%2==0) {
								arr[cnt+i] = list2.get(idx2);
								idx2++;
							}
							else {
								arr[cnt+i] = list1.get(idx1);
								idx1++;
							}
						}
					}
					cnt = line1.length();
				}
				else {
					arr[cnt] = list1.get(idx1++);
				}
			}
			else {
				if(list1.get(idx1)>=list2.get(idx2)) {
					int c = line1.length()-cnt;
					if(c%2==1) {
						for(int i = 0;i<c;i++) {
							if(i%2==0) {
								arr[cnt+i] = list1.get(idx1);
								idx1++;
							}
							else {
								arr[cnt+i] = list2.get(idx2);
								idx2++;
							}
						}
					}
					else {
						for(int i = 0;i<c;i++) {
							if(i%2==1) {
								arr[cnt+i] = list2.get(idx2);
								idx2++;
							}
							else {
								arr[cnt+i] = list1.get(idx1);
								idx1++;
							}
						}
					}
					cnt = line1.length();
				}
				else {
					arr[cnt] = list2.get(idx2++);
				}
			}
			cnt++;
		}
		
		System.out.println(new String(arr));
	}
}
