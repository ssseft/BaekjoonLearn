package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2961 {
	static long min;
	static long n;
	static List<long[]> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			long c = Long.parseLong(st.nextToken());
			long s = Long.parseLong(st.nextToken());
			list.add(new long[] {c,s});
		}
		
		min = Long.MAX_VALUE;
		cal(0,0,0,0);
		System.out.print(min);
	}
	static void cal(int idx,int cnt,long cvalue,long svalue) {
		if(idx==n) {
			if(cnt!=0) {
				min = Math.min(min, Math.abs(cvalue-svalue));
			}
			return;
		}
		cal(idx+1,cnt,cvalue,svalue);
		if(cvalue==0) cvalue = list.get(idx)[0];
		else cvalue *= list.get(idx)[0];
		svalue += list.get(idx)[1];
		cal(idx+1,cnt+1,cvalue,svalue);
	}
}
