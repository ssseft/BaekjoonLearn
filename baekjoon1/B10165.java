package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B10165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		
		List<int[]> bus = new ArrayList<>();
		
		for(int i =1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			bus.add(new int[] {s1,s1>s2?s2+=n:s2,i});
		}
		
		Collections.sort(bus,(a,b)->{
			if(a[0]==b[0]) {
				return b[1]-a[1];
			}
			else {
				return a[0]-b[0];
			}
		});
		
		int start = bus.get(0)[0];
		int end = bus.get(0)[1];
		int lastidx = bus.get(0)[2];
		List<Integer> result = new ArrayList<>();
		
		for(int i = 1;i<m;i++) {
			int[] c = bus.get(i);
			if(start<=c[0]&&end>=c[1]){
				continue;
			}
			else {
				result.add(lastidx);
				start = c[0];
				end = c[1];
				lastidx = c[2];
			}
		}
		result.add(lastidx);
		
		int idx = 0;
		end-=n;
		while(end>=0&&idx<bus.size()) {
			int[] c = bus.get(idx);
			idx++;
			if(!result.contains(c[2])) continue;
			
			if(end<c[1]) {
				break;
			}
			
			result.remove((Integer)c[2]);
		}
		
		Collections.sort(result);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i+" ");
		}
		
		System.out.print(sb.toString().trim());
	}
}
