package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2109 {
	
	static class lecture implements Comparable<lecture> {
			int day,price;
			public lecture(int day, int price) {
				this.day = day;
				this.price = price;
			}
			@Override
			public int compareTo(lecture l) {
				if(this.day==l.day) {
					return l.price-this.price;
				}
				return this.day-l.day;
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<lecture> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new lecture(d,p));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i<list.size();i++) {
			lecture c = list.get(i);
			pq.add(c.price);
			
			if(pq.size()>c.day) {
				pq.poll();
			}
		}
		
		int money = 0;
		while(!pq.isEmpty()) {
			money+=pq.poll();
		}
		
		System.out.println(money);
	}
}
