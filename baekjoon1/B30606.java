package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B30606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i = 0;i<t;i++) {
			Long num = Long.parseLong(br.readLine());
			int cnt = 1;
			
			while(Long.bitCount(num+cnt)>cnt) cnt++;
			
			sb.append(cnt-1+"\n");
		} 
		
		System.out.print(sb.toString().trim());
		
		String a = Integer.toBinaryString(239);
		System.out.println(a);
	}
}
