import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] exist = new boolean[1000001];
		int[] idx = new int[1000001];
		int[] score = new int[n+1];
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			exist[c] =true;
			idx[c] = i;
			list.add(c);
		}
		
		for(int i= 0;i<n;i++) {
			int c = list.get(i);
			for(int j = c;j<=1000000;j+=c) {
				if(exist[j]) {
					score[i]++;
					score[idx[j]]--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			sb.append(score[i]+" ");
		}
		System.out.print(sb);
	}
}