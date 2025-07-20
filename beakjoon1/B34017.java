package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B34017 {
	static Map<Long,Long> m1;
	static Map<Long,Long> m2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		m1 = new HashMap<>();
		m2 = new HashMap<>();
		m1.put(1L,1L);
		m1.put(2L,2L);
		m2.put(0L, 0L);
		m2.put(1L, 1L);
		m2.put(2L, 3L);
		m2.put(3L, 10L);
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			long c = Long.parseLong(br.readLine());
			sb.append(sum(c)+"\n");
		}
		System.out.print(sb.toString());
		
	}
	static long recursion(long num) {
		if(m1.containsKey(num)) return m1.get(num);
		
		long k = num/3;
		long r = num%3;
		long result;
		
		if(r==0) {
			result = 2*recursion(k)+2*recursion(k+1)+1;
		}
		else if(r==1) {
			result = 2*recursion(k+2)-1;
		}
		else {
			result = -2*recursion(k+1)-2*recursion(k+2)+2;
		}
		
		m1.put(num, result);
		
		return result;
	}
	
	static long sum(long num) {
		if(m2.containsKey(num)) return m2.get(num);
		
		long r = num%3;
		
		long result;
		
		if (r==0) {
			long k = num/3;
	        result = 2*sum(k+1)+2*k+2;
	    }
		else if(r==1){
			long k = (num-1)/3;
	        result = 2*sum(k+1)+2*k+2*recursion(k+2)+1;
	    }
	    else {
	    	long k = (num-2)/3;
	    	result = 2*sum(k+1)+2*k-2*recursion(k+1)+3;
	    }
		
		
		m2.put(num, result);
		return result;
	}
}
