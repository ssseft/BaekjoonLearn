package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer>[] list = new ArrayList[n];
		for(int i = 0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		
		int topnode = 0;
		for(int i = 0;i<n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c!=-1) {
				list[c].add(i);
			}
			else {
				topnode = i;
			}
			
		}
		boolean[] ch = new boolean[n];
		int remvidx = Integer.parseInt(br.readLine());
		if(topnode==remvidx) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(remvidx);
		while(!q.isEmpty()) {
			int c = q.poll();
			ch[c] = true;
			for(int a : list[c]) {
				q.add(a);
			}
		}
		
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			if(!ch[i]){
				boolean is = true;
				for(int a : list[i]) {
					if(!ch[a]) {
						is = false;
						break;
					}
				}
				if(is) cnt++;
			}
		}
		System.out.print(cnt);
	}
}
