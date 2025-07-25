package beakjoon1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1039 {
	static boolean[] ov;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int max = 0;
		int s = n;
		int m = 0;
		while(s>0) {
			s/=10;
			m++;
		}
		
		while(k-->0) {
			int size = q.size();
			ov = new boolean[(int)Math.pow(10, m)];
			for(int i = 0;i<size;i++) {
				int c = q.poll();
				int[] arr = new int[m];
				for(int j = m-1;j>=0;j--) {
					arr[j] = c%10;
					c/=10;
				}
				for(int a = 0;a<m-1;a++) {
					for(int b = a+1;b<m;b++) {
						int num = 0;
						if(a==0&&arr[b]==0) continue;
						for(int d = 0;d<m;d++) {
							if(d==a) num+= Math.pow(10, m-d-1)*arr[b];
							else if(d==b) num+=Math.pow(10, m-d-1)*arr[a];
							else num+= Math.pow(10, m-d-1)*arr[d];
						}
						if(!ov[num]) q.add(num);
						ov[num] = true;
					}
				}
			}
		}
		if(q.isEmpty()) {
			System.out.print(-1);
			return;
		}
		while(!q.isEmpty()) {
			int c = q.poll();
			max = Math.max(max, c);
		}
		System.out.print(max);
	}
}
