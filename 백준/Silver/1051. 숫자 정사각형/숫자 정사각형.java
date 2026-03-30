import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			String l = sc.nextLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j)-'0';
			}
		}
		
		int s = Math.min(n, m);
		boolean ch = true;
		while(s>0) {
			for(int i = 0;i<n-s;i++) {
				for(int j = 0;j<m-s;j++) {
					if(arr[i][j]==arr[i+s][j]&&arr[i][j]==arr[i][j+s]&&arr[i][j]==arr[i+s][j+s]) {
						ch = false;
						break;
					}
				}
				if(!ch) break;
			}
			if(!ch) break;
			s--;
		}
		s++;
		System.out.print(s*s);
	}
}