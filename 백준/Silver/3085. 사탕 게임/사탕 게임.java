import java.util.*;

public class Main {
	static int n,max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		max = 1;
		char arr[][] = new char[n][n];
		for(int i = 0;i<n;i++) {
			String l = sc.next();
			for(int j = 0;j<n;j++) {
				arr[i][j] = l.charAt(j);
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				cal(arr,i,j);
			}
		}
		
		System.out.print(max);
	}
	static void cal(char[][] arr, int x, int y) {
		char[][] new_arr = new char[n][n];
		int rx = x;
		int ry = y+1;
		if(ry<n) {
			for(int i = 0;i<n;i++) {
				new_arr[i] = arr[i].clone();
			}
			
			new_arr[rx][ry] = arr[x][y];
			new_arr[x][y] = arr[rx][ry];
			
			int t = 1;
			char last;
			for(int i = 0;i<n;i++) {
				last = 'a';
				int cnt = 0;
				for(int j = 0;j<n;j++) {
					char c = new_arr[i][j];
					if(last!=c) {
						t = Math.max(t, cnt);
						cnt = 1;
						last = c;
					}
					else {
						cnt++;
					}
					t = Math.max(t, cnt);
				}
			}
			
			for(int i = 0;i<n;i++) {
				last = 'a';
				int cnt = 0;
				for(int j = 0;j<n;j++) {
					char c = new_arr[j][i];
					if(last!=c) {
						t = Math.max(t, cnt);
						cnt = 1;
						last = c;
					}
					else {
						cnt++;
					}
				}
				t = Math.max(t, cnt);
			}
			max = Math.max(max, t);
		}
		
		
		int dx = x+1;
		int dy = y;
		
		if(dx==n) return;
		
		for(int i = 0;i<n;i++) {
			new_arr[i] = arr[i].clone();
		}
		
		new_arr[dx][dy] = arr[x][y];
		new_arr[x][y] = arr[dx][dy];
		
		int t = 1;
		char last;
		for(int i = 0;i<n;i++) {
			last = 'a';
			int cnt = 0;
			for(int j = 0;j<n;j++) {
				char c = new_arr[i][j];
				if(last!=c) {
					t = Math.max(t, cnt);
					cnt = 1;
					last = c;
				}
				else {
					cnt++;
				}
				t = Math.max(t, cnt);
			}
		}
		
		for(int i = 0;i<n;i++) {
			last = 'a';
			int cnt = 0;
			for(int j = 0;j<n;j++) {
				char c = new_arr[j][i];
				if(last!=c) {
					t = Math.max(t, cnt);
					cnt = 1;
					last = c;
				}
				else {
					cnt++;
				}
				t = Math.max(t, cnt);
			}
		}
		max = Math.max(max, t);
		
	}
}