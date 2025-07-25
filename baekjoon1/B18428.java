package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18428 {
	static int n;
	static char[][] arr;
	static List<int[]> teacher;
	static boolean possible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new char[n][n];
		teacher = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if(arr[i][j]=='T') teacher.add(new int[] {i,j});
			}
		}
		possible = false;
		backtraking();
		if(possible) System.out.print("YES");
		else System.out.print("NO");
		
	}
	static void backtraking() {
		for(int i = 0;i<n*n-2;i++) {
			for(int j = i+1;j<n*n-1;j++) {
				for(int k = j+1;k<n*n;k++) {
					if(arr[i/n][i%n]!='X'||arr[j/n][j%n]!='X'||arr[k/n][k%n]!='X') continue;
					arr[i/n][i%n] = 'O';
					arr[j/n][j%n] = 'O';
					arr[k/n][k%n] = 'O';
					if(search()) {
						possible = true;
						return;
					}
					arr[i/n][i%n] = 'X';
					arr[j/n][j%n] = 'X';
					arr[k/n][k%n] = 'X';
				}
			}
		}
	}
	static boolean search() {
		for(int[] c : teacher) {
			int x = c[0];
			int y = c[1];
			boolean[] ch = new boolean[4];
			for(int i = 1;i<n;i++) {
				int cx = x+i;
				int nx = x-i;
				int cy = y+i;
				int ny = y-i;
				if(!ch[0]) {
					if(cx>=n||arr[cx][y]=='O') ch[0] = true;
					else if(arr[cx][y]=='S') return false;
				}
				if(!ch[1]) {
					if(nx<0||arr[nx][y]=='O') ch[1] = true;
					else if(arr[nx][y]=='S') return false;
				}
				if(!ch[2]) {
					if(cy>=n||arr[x][cy]=='O') ch[2] = true;
					else if(arr[x][cy]=='S') return false;
				}
				if(!ch[3]) {
					if(ny<0||arr[x][ny]=='O') ch[3] = true;
					else if(arr[x][ny]=='S') return false;
				}
			}
		}
		return true;
	}
}
