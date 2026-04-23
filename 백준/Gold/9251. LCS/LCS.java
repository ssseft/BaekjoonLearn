import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		int x = A.length();
		int y = B.length();
		
		int[][] dp = new int[x+1][y+1];
		
		for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
		int result = dp[x][y];
		System.out.print(result);
		
		
		
	}
}