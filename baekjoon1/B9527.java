package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		String a = Long.toBinaryString(A-1);
		String b = Long.toBinaryString(B);
		
		System.out.println(sol(b)-sol(a));
		
	}
	
	public static long sol(String num) {
		long result = 0;
		int size = num.length()-1;
		long cnt = 0;
		int idx = 1;
		
		result += size*(long)Math.pow(2, size-1);
		cnt++;
		
		while(idx<=size) {
			if(num.charAt(idx)=='1') {
				result += (cnt*(long)Math.pow(2, size-idx))+(size-idx)*(long)Math.pow(2, size-idx-1);
				cnt++;
			}
			idx++;
		}
		
		// 1010
		for(int i =0;i<num.length();i++) {
			if(num.charAt(i)=='1') result++;
		}
		
		return result;
	}
}
