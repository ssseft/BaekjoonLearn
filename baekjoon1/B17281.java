package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17281 {
	static int max,n;
	static int[][] game;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		game = new int[n][9];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<9;j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		boolean[] used = new boolean[9];
		int[] arr = new int[9];
		used[0] = true;
		arr[3] = 0;
		search(0,used,arr);
		
		System.out.println(max);
	}
	static void search(int cnt,boolean[] used,int[] arr) {
		if(cnt==9) {
			cal(arr);
			return;
		}
		if(cnt==3) {
			search(cnt+1,used,arr);
		}
		
		for(int i = 1;i<9;i++) {
			if(!used[i]) {
				used[i] = true;
				arr[cnt] = i;
				search(cnt+1,used,arr);
				used[i] = false;
				arr[cnt] = 0;
			}
		}
		
	}
	static void cal(int[] arr) {
		int seat = 0;
		int score = 0;
		for(int i = 0;i<n;i++) {
			int out = 0;
			boolean[] own = new boolean[4];
			while(out<3) {
				int c = game[i][arr[seat]];
				if(c==0) out++;
				else {
					if(c==1) {
						if(own[3]) score++;
						own[3] = own[2];
						own[2] = own[1];
						own[1] = true;
					}
					else if(c==2) {
						if(own[3]) score++;
						if(own[2]) score++;
						own[3] = own[1];
						own[2] = true;
						own[1] = false;
					}
					else{
						for(int j = 1;j<4;j++) {
							if(own[j]) score++;
							own[j] = false;
						}
						if(c==3) {
							own[3] = true;
						}
						else {
							score++;
						}
					}
				}
				seat = (seat+1)%9;
			}
		}
		max = Math.max(max, score);
	}
}