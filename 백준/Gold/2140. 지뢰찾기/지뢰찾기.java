import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		sc.nextLine();
		boolean[][] boom = new boolean[n][n];
		for(int i = 0;i<n;i++) {
			String a=  sc.nextLine();
			for(int j = 0;j<n;j++) {
				if(a.charAt(j)=='#') {
					arr[i][j] = 9;
					boom[i][j] = true;
				}
				else arr[i][j] = a.charAt(j)-'0';
			}
		}
		
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,1,-1,1,0,-1};
		int ans = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(boom[i][j]) {
					boolean ch = true;
					for(int k = 0;k<8;k++) {
						int cx = i+dx[k];
						int cy = j+dy[k];
						if(cx>=0&&cy>=0&&cx<n&&cy<n&&arr[cx][cy]==0) {
							ch = false;
							break;
						}
					}
					if(ch) {
						for(int k = 0;k<8;k++) {
							int cx = i+dx[k];
							int cy = j+dy[k];
							if(cx>=0&&cy>=0&&cx<n&&cy<n) {
								arr[cx][cy]--;
							}
						}
						ans++;
					}
				}
			}
		}
		System.out.print(ans);
	}
}
