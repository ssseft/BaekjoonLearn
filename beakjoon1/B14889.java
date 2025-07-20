package beakjoon1;
import java.util.Scanner;

public class B14889 {
	static int[][] arr;
	static int n;
	static int min;
	static boolean[] include;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n+1][n+1];
		for(int i = 1; i<n+1;i++) {
			for(int j = 1; j<n+1;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		include = new boolean[n+1];
		dfs(0,1);
		
		System.out.print(min);
		sc.close();
	}
	public static void dfs(int size,int start) {
		if(size == n/2) {
			int startTeam = 0;
			int linkTeam = 0;
			for(int i =1;i<n+1;i++) {
				for(int j = 1;j<n+1;j++) {
					if(include[i]&&include[j]) {
						startTeam+=arr[i][j];
					}
					else if(!include[i]&&!include[j]) {
						linkTeam+=arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(startTeam-linkTeam));
			return;
		}
		for(int i = start;i<n+1;i++) {
			include[i] = true;
			dfs(size+1,i+1);
			include[i] = false;
		}
	}
}
