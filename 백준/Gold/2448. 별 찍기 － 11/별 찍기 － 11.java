import java.util.Scanner;

public class Main {
	public static boolean[][] check;
	public static void main(String[] args	) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		check = new boolean[n][2*n];
		StringBuilder sb = new StringBuilder();
		implement(0,n-1,n);
		for(int i =0; i<n; i++) {
			for(int j =0; j<n*2-1;j++) {
				if(check[i][j]) {
					sb.append('*');
				}
				else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	public static void implement(int x, int y, int n) {
		if(n == 3) {
			check[x][y] = true;
			check[x+1][y-1] = check[x+1][y+1] = true;
			check[x+2][y-2] = check[x+2][y-1] = check[x+2][y] = check[x+2][y+1] = check[x+2][y+2]  = true;
			return;
		}
		else {
			int newsize = n/2;
			implement(x,y,newsize);
			implement(x+newsize,y-newsize,newsize);
			implement(x+newsize,y+newsize,newsize);
		}
	}
}