package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9328 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2;
		
		int t = Integer.parseInt(br.readLine());
		Queue<int[]> q;
		boolean[][] visited;
		
		while(t-->0) {
			
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			String[] field = new String[h];
			for(int i = 0;i<h;i++) {
				field[i] = br.readLine();
			}
			int bit = 0;
			String key = br.readLine();
			
			if(key.charAt(0)!='0') {
				for(int i = 0;i<key.length();i++) {
					char cur = key.charAt(i);
					bit += (1<<(cur-'a'));
				}
			}
			q = new LinkedList<>();
			int cnt = 0;
			for(int i =0;i<h;i++) {
				if(field[i].charAt(0)=='$') {
					cnt++;
					sb2 = new StringBuilder(field[i]);
					sb2.setCharAt(0,'.');
					field[i] = sb2.toString();
				}
				if(field[i].charAt(w-1)== '$'){
					cnt++;
					sb2 = new StringBuilder(field[i]);
					sb2.setCharAt(w-1,'.');
					field[i] = sb2.toString();
				}
			}
			for(int i = 1;i<w-1;i++) {
				if(field[0].charAt(i)=='$') {
					cnt++;
					sb2 = new StringBuilder(field[0]);
					sb2.setCharAt(i,'.');
					field[0] = sb2.toString();
				}
				if(field[h-1].charAt(i)=='$') {
					cnt++;
					sb2 = new StringBuilder(field[h-1]);
					sb2.setCharAt(i,'.');
					field[h-1] = sb2.toString();
				}
			}
			
			while(true) {
				List<int[]>	list = search(field,h,w,bit);
				for(int[] c : list) {
					q.add(c);
				}
				int a = 0;
				visited = new boolean[h][w];
				while(!q.isEmpty()) {
					int[] c = q.poll();
					
					for(int i = 0;i<4;i++) {
						int cx = c[0]+dx[i];
						int cy = c[1]+dy[i];
						
						if(cx>=0&&cy>=0&&cx<h&&cy<w&&!visited[cx][cy]) {
							char cur = field[cx].charAt(cy);
							if(cur=='.'){
								q.add(new int[] {cx,cy});
								visited[cx][cy] = true;
							}
							else if(cur>='a'&&cur<='z') {
								int k = cur-'a';
								if((bit&(1<<k))==0) a++;
								bit = bit|(1<<k);
								sb2 = new StringBuilder(field[cx]);
								sb2.setCharAt(cy, '.');
								field[cx] = sb2.toString();
								visited[cx][cy] = true;
								q.add(new int[] {cx,cy});
								visited[cx][cy] = true;
							}
							else if(cur=='$') {
								cnt++;
								q.add(new int[] {cx,cy});
								sb2 = new StringBuilder(field[cx]);
								sb2.setCharAt(cy, '.');
								field[cx] = sb2.toString();
								visited[cx][cy] = true;
							}
							else if(cur>='A'&&cur<='Z'&&(bit&(1<<(cur-'A')))!=0){
								visited[cx][cy] = true;
								q.add(new int[] {cx,cy});
							}
						}
					}
				}
				
				if(a==0) break;
			}
			
			sb.append(cnt+"\n");
		}
		
		
		
		System.out.print(sb.toString().trim());
		
		
		
	}
	static List<int[]> search(String[] field, int h, int w, int bit) {
		List<int[]> spot = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			char left = field[i].charAt(0);
			if (left == '.' || left == '$' || (left >= 'a' && left <= 'z') ||
				(left >= 'A' && left <= 'Z' && (bit & (1 << (left - 'A'))) != 0)) {
				spot.add(new int[] {i, 0});
			}

			char right = field[i].charAt(w - 1);
			if (right == '.' || right == '$' || (right >= 'a' && right <= 'z') ||
				(right >= 'A' && right <= 'Z' && (bit & (1 << (right - 'A'))) != 0)) {
				spot.add(new int[] {i, w - 1});
			}
		}

		for (int i = 1; i < w - 1; i++) {
			char top = field[0].charAt(i);
			if (top == '.' || top == '$' || (top >= 'a' && top <= 'z') ||
				(top >= 'A' && top <= 'Z' && (bit & (1 << (top - 'A'))) != 0)) {
				spot.add(new int[] {0, i});
			}

			char bottom = field[h - 1].charAt(i);
			if (bottom == '.' || bottom == '$' || (bottom >= 'a' && bottom <= 'z') ||
				(bottom >= 'A' && bottom <= 'Z' && (bit & (1 << (bottom - 'A'))) != 0)) {
				spot.add(new int[] {h - 1, i});
			}
		}

		return spot;
	}

}
