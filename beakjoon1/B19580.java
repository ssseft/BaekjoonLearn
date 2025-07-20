package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B19580 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> person = new PriorityQueue<int[]>((a,b)->{
			if(a[1]==b[1]) return a[0]-b[0];
			else return a[1]-b[1];
		});
		
		PriorityQueue<int[]> store = new PriorityQueue<int[]>((a,b)->{
			if(a[0]==b[0]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			person.add(new int[] {min,max});
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			store.add(new int[] {price,num});
		}
		
		int cnt = 0;
		
		while(!person.isEmpty()&&!store.isEmpty()) {
			int[] c = person.poll();
			int[] s = store.peek();
			if(c[0]>s[0]) {
				store.poll();
				continue;
			}
			if(c[1]<s[0]) continue;
			
			int[] sto = store.poll();
			if(sto[1]!=1) {
				store.add(new int[] {sto[0],sto[1]-1});
			}
			System.out.println(c[0]+" "+c[1]);
			System.out.println(s[0]+" "+s[1]);
			System.out.println();
			cnt++;
		}
		
		
		System.out.print(cnt);
		
		
	}
}
