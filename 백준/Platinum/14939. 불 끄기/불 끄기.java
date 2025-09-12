import java.util.*;

public class Main {
	static boolean[][] arr,arr2;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr2 = new boolean[10][10];
		for(int i = 0;i<10;i++) {
			String l = sc.next();
			for(int j = 0;j<10;j++) {
				if(l.charAt(j)=='O') arr2[i][j] = true;
			}
		}
		min = 9999999;
		visited = new boolean[10];
		choice(0);
		
		System.out.print(min);
	}
	static void choice(int cn) {
		if(cn==10) {
			arr = new boolean[10][10];
			for(int i = 0;i<10;i++) {
				arr[i] = arr2[i].clone();
			}
			int S = 0;
			for(int i = 0;i<10;i++) {
				if(visited[i]) {
					go(0,i);
					S++;
				}
			}
			recur(1,S);
			return;
		}
		choice(cn+1);
		visited[cn] = true;
		choice(cn+1);
		visited[cn] = false;
	}
	static void recur(int dep, int cnt) {
		if(dep==10) {
			for(int i = 0;i<10;i++) {
				if(arr[9][i]) return;
			}
			min = Math.min(min, cnt);
			return;
		}
		
		for(int i = 0;i<10;i++) {
			if(arr[dep-1][i]) {
				go(dep,i);
				cnt++;
			}
		}
		recur(dep+1,cnt);
	}
	static void go(int x,int y) {
		arr[x][y] = !arr[x][y];
		if(x>0) arr[x-1][y] = !arr[x-1][y];
		if(y>0) arr[x][y-1] = !arr[x][y-1];
		if(x<9) arr[x+1][y] = !arr[x+1][y];
		if(y<9) arr[x][y+1] = !arr[x][y+1];
	}
}
