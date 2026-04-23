import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[1002][1002];
		for(int i = 1;i<=n;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int x = x1;x<x1+x2;x++) {
				for(int y = y1;y<y1+y2;y++) {
					arr[x][y] = i;
				}
			}
		}
		int[] cnt = new int[n+1]; 
		for(int i = 0;i<=1001;i++) {
			for(int j = 0;j<=1001;j++) {
				cnt[arr[i][j]]++;
			}
		}
		
		for(int i = 1;i<=n;i++) {
			System.out.println(cnt[i]);
		}
	}
}
