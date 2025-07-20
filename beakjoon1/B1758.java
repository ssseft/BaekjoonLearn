package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list,(a,b)->b-a);
		
		long money = 0;
		money+= list.get(0);
		
		for(int i = 1;i<n;i++) {
			if(list.get(i)-i>0) {
				money+=(list.get(i)-i);
			}
		}
		System.out.print(money);
	}
}
