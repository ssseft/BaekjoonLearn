package beakjoon1;
import java.util.Scanner;

public class B1987 {
	static int n;
	static int m;
	static String[] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[] check;
	static int cnt;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new String[n];
		for(int i = 0; i<n;i++) {
			arr[i] = sc.nextLine();
		}
		sc.close();
		check = new boolean[27];
		cnt = 1;
		max = 1;
		check[arr[0].charAt(0)-65] = true;
		dfs(0,0);
		System.out.print(max);
	}
	public static void dfs(int x, int y) {
		boolean ch = false;
		for(int i =0 ;i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m) {
				int a = arr[cx].charAt(cy)-65;
				if(!check[a]) {
					check[a] = true;
					cnt++;
					if(max<cnt) {
						max = cnt;
					}
					dfs(cx,cy);
					cnt--;
					check[a] = false;
					ch = true;
				}
			}
		}
		if(!ch) {
			return;
		}
	}
}
