package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Asize = Integer.parseInt(st.nextToken());
		int Bsize = Integer.parseInt(st.nextToken());
		int[] A = new int[Asize];
		int[] B = new int[Bsize];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<Asize;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<Bsize;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		int index1 = 0;
		int index2 = 0;
		while(index1<Asize&&index2<Bsize) {
			if(A[index1]<=B[index2]) {
				sb.append(A[index1++]+" ");
			}
			else {
				sb.append(B[index2++]+" ");
			}
		}
		if(index1<Asize) {
			for(int i = index1;i<Asize;i++) {
				sb.append(A[i]+" ");
			}
		}
		else {
			for(int i = index2;i<Bsize;i++) {
				sb.append(B[i]+" ");
			}
		}
		System.out.print(sb.toString().trim());
	}
}
