package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B2632 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] A = new int[n];
		int[] B = new int[m];
		for(int i = 0;i<n;i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0;i<m;i++) {
			B[i] = Integer.parseInt(br.readLine());
		}
		
		HashMap<Integer, Integer> Amap = new HashMap<>();
		HashMap<Integer, Integer> Bmap = new HashMap<>();
		HashSet<Integer> alist = new  HashSet<>();
		for(int i = 0;i<n;i++) {
			int sum = 0;
			for(int j = i;j<n+i-1;j++) {
				sum+=A[j%n];
				alist.add(sum);
				Amap.put(sum,Amap.getOrDefault(sum,0)+1);
			}
			if(i==0) {
				sum+=A[n-1];
				Amap.put(sum,Amap.getOrDefault(sum,0)+1);
				alist.add(sum);
			}
		}
		
		for(int i = 0;i<m;i++) {
			int sum = 0;
			for(int j = i;j<m+i-1;j++) {
				sum+=B[j%m];
				Bmap.put(sum,Bmap.getOrDefault(sum,0)+1);
			}
			if(i==0) {
				sum+=B[m-1];
				Bmap.put(sum,Bmap.getOrDefault(sum,0)+1);
			}
		}
		
		int cnt = 0;
		if(Amap.containsKey(num)) cnt += Amap.get(num);
		if(Bmap.containsKey(num)) cnt += Bmap.get(num);
		
		for(int a : alist) {
			if(Bmap.containsKey(num-a)) {
				cnt+= Amap.get(a)*Bmap.get(num-a);
			}
		}
		
		System.out.print(cnt);
	}
}
