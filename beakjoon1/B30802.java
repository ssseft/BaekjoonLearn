package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B30802 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st2.nextToken());
		int p = Integer.parseInt(st2.nextToken());
		int cnt = 0;
		
		for(int i =0;i<6;i++) {
			int c = Integer.parseInt(st.nextToken());
			cnt+=((c-1)/t);
			if(c!=0)cnt++;
		}
		
		System.out.println(cnt);
		System.out.println(n/p+" "+n%p);
	}
}
