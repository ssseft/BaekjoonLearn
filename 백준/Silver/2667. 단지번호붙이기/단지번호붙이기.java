import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	public static int n;
	public static boolean[][] visited;
	public static int[][] num;
	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n][n];
		sc.nextLine();
		for(int i =0;i<n;i++) {
			String nums = sc.nextLine();
			for(int j =0; j<n; j++) {
				num[i][j] = nums.charAt(j) - '0';
			}
		}
		visited = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0; i<n;i++) {
			for(int j= 0; j<n;j++) {
				if(num[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(i,j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i =0;i<list.size();i++	) {
			System.out.println(list.get(i));
		}
		
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		count++;
		int[] nx = {0,0,-1,1};
		int[] ny = {1,-1,0,0};
		for(int i =0; i<4; i++) {
			int newx = x+nx[i];
			int newy = y+ny[i];
			if (newx >= 0 && newx < n && newy >= 0 && newy < n && !visited[newx][newy] && num[newx][newy] == 1) {
                dfs(newx, newy);
            }
		}
		
	}
}
