package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long[] arr2 = new long[m];
		for(int i = 0;i<m;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Long,Long> s1 = new HashMap<>();
		Map<Long,Long> s2 = new HashMap<>();
		
		for(int i =0;i<n;i++) {
			long sum = 0;
			for(int j = i;j<n;j++) {
				sum+=arr[j];
				s1.put(sum, s1.getOrDefault(sum, 0L)+1);
			}
		}
		
		for(int i =0;i<m;i++) {
			long sum = 0;
			for(int j = i;j<m;j++) {
				sum+=arr2[j];
				s2.put(sum, s2.getOrDefault(sum, 0L)+1);
			}
		}
		
		
		long cnt= 0;
		for(long A : s1.keySet()) {
			long sla = t-A;
			if(s2.containsKey(sla)) {
				cnt+= s1.get(A) * s2.get(sla);
			}
		}
		
		System.out.println(cnt);
	}
}
