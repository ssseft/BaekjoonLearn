package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B12100 {
	static int max;
	static int n;
	static Stack<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		max = 0;
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		q = new Stack<>();
		backtracking(0, arr);
		System.out.print(max);
		
	}
	static void backtracking(int cnt,int[][] arr) {
		if(cnt==5) {
			return;
		}
		for(int i = 0;i<4;i++) {
			int[][] arr2 = move(arr,i);
			backtracking(cnt+1,arr2);	
		}
	}
	static int[][] move(int[][] arr, int dir){
		int[][] movearr = new int[n+1][n+1];
		//위 오른 아래 왼
		if(dir==0) {
			for(int i = 1;i<=n;i++) {
				q.clear();
				boolean ch = false;
				for(int j = n;j>=1;j--) {
					int c  = arr[j][i];
					if(c!=0) {
						if(q.isEmpty()) q.add(c);
						else if(ch) {
							q.add(c);
							ch = false;
						}
						else {
							int last = q.pop();
							if(last==c) {
								q.add(c*2);
								ch = true;
								max = Math.max(max, c*2);
							}
							else {
								q.add(last);
								q.add(c);
							}
						}
					}
				}
				int idx = q.size();
				while(!q.isEmpty()) {
					movearr[idx--][i] = q.pop();
				}
			}
		}
		if(dir==2) {
			for(int i = 1;i<=n;i++) {
				boolean ch = false;
				q.clear();
				for(int j = 1;j<=n;j++) {
					int c  = arr[j][i];
					if(c!=0) {
						if(q.isEmpty()) q.add(c);
						else if(ch) {
							q.add(c);
							ch = false;
						}
						else {
							int last = q.pop();
							if(last==c) {
								q.add(c*2);
								max = Math.max(max, c*2);
								ch = true;
							}
							else {
								q.add(last);
								q.add(c);
							}
						}
					}
				}
				int idx = n-q.size()+1;
				while(!q.isEmpty()) {
					movearr[idx++][i] = q.pop();
				}
			}
		}
		
		if(dir==1) {
			for(int i = 1;i<=n;i++) {
				q.clear();
				boolean ch = false;
				for(int j = 1;j<=n;j++) {
					int c  = arr[i][j];
					if(c!=0) {
						if(q.isEmpty()) q.add(c);
						else if(ch) {
							q.add(c);
							ch = false;
						}
						else {
							int last = q.pop();
							if(last==c) {
								q.add(c*2);
								max = Math.max(max, c*2);
								ch = true;
							}
							else {
								q.add(last);
								q.add(c);
							}
						}
					}
				}
				int idx = n-q.size()+1;
				while(!q.isEmpty()) {
					movearr[i][idx++] = q.pop();
				}
			}
		}
		
		if(dir==3) {
			for(int i = 1;i<=n;i++) {
				q.clear();
				boolean ch = false;
				for(int j = n;j>=1;j--) {
					int c  = arr[i][j];
					if(c!=0) {
						if(q.isEmpty()) q.add(c);
						else if(ch) {
							q.add(c);
							ch = false;
						}
						else {
							int last = q.pop();
							if(last==c) {
								q.add(c*2);
								max = Math.max(max, c*2);
								ch = true;
							}
							else {
								q.add(last);
								q.add(c);
							}
						}
					}
				}
				int idx = q.size();
				while(!q.isEmpty()) {
					movearr[i][idx--] = q.pop();
				}
			}
		}
		
		return movearr;
	}
}