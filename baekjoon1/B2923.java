package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2923 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] A = new int[100];
		int[] B = new int[100];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=n;i++) {
			
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			int eA = Integer.parseInt(st.nextToken());
			int eB = Integer.parseInt(st.nextToken());
			
			A[eA]++;
			B[eB]++;
			
			int[] Acount = A.clone();
			int[] Bcount = B.clone();
			
			int p1 = 1;
			int p2 = 99;
			
			while(p1<100&&p2>0) {
				if(Acount[p1]==0) {
					p1++;
					continue;
				}
				if(Bcount[p2]==0) {
					p2--;
					continue;
				}
				
				if(Acount[p1]>0&&Bcount[p2]>0) {
					if(p1+p2>max) {
						max = p1+p2;
					}
					
					if(Acount[p1]>Bcount[p2]) Acount[p1] -= Bcount[p2--];
					else Bcount[p2] -= Acount[p1++];
				}
			}
			sb.append(max+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
