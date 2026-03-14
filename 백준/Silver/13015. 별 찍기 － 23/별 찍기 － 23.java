import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		boolean[][] star = new boolean[n*2-1][4*n-3];
		int a = 0;
		int b = n-1;
		int c = 3*(n-1);
		int d = 4*(n-1);
		for(int i = 0;i<2*n-1;i++) {
			if(i==0||i==2*n-2) {
				for(int j = a;j<=b;j++) {
					star[i][j] = true;
				}
				for(int j = c;j<=d;j++) {
					star[i][j] = true;
				}
			}
			else {
				star[i][a] = true;
				star[i][b] = true;
				star[i][c] = true;
				star[i][d] = true;
			}
			if(i<n-1) {
				a++; b++; c--; d--;
			}
			else {
				a--; b--; c++; d++;
			}
		}
        for (int i = 0; i < 2 * n - 1; i++) {
        int last = 4 * n - 4;
        while (last >= 0 && !star[i][last]) {
            last--;
        }

        for (int j = 0; j <= last; j++) {
            if (star[i][j]) sb.append("*");
            else sb.append(" ");
        }
        sb.append("\n");
        }
		System.out.print(sb);
	}
}