import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] star = new boolean[1+((n-1)*4)][1+((n-1)*4)];
		recur(n,star,0,0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<star.length;i++) {
			for(int j=  0;j<star.length;j++) {
				if(star[i][j]) sb.append('*');
				else sb.append(' ');
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void recur(int n, boolean[][] star, int x, int y) {

		if(n==1) {
			star[x][y] = true;
			return;
		}
        for (int i = y; i <= y+((n-1)*4); i++) {
            star[x][i] = true;
            star[x+((n-1)*4)][i] =true;
        }

        for (int i = x; i <= x+((n-1)*4); i++) {
            star[i][y] = true;
            star[i][y+((n-1)*4)] = true;
        }
		
		recur(n-1,star,x+2,y+2);
	}
}
