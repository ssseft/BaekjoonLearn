package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B34030 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> odd = new PriorityQueue<Integer>();
		PriorityQueue<Integer> even = new PriorityQueue<Integer>();
		boolean c1 = false;
		boolean c2 = false;
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c%2==1) {
				if(!odd.isEmpty()&&odd.peek()>c) {
					
				}
			}
		}
		
	}
}
