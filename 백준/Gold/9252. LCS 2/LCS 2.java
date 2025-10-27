import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String l = sc.next();
		String w = sc.next();
		
		int x = l.length();
		int y = w.length();
		
		char[] a = new char[x+1];
		char[] b = new char[y+1];
		
		for(int i = 1;i<=x;i++) a[i] = l.charAt(i-1);
		for(int i = 1;i<=y;i++) b[i] = w.charAt(i-1);
		
		int[][] dp = new int[x+1][y+1];
		
		for(int i = 1;i<=x;i++) {
			for(int j = 1;j<=y;j++) {
				if(a[i]==b[j]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(dp[x][y]);
		if(dp[x][y]==0) return;
		int max = dp[x][y];
		
		while(max>0) {
			if(dp[x][y]==dp[x][y-1]) y--;
			else if(dp[x][y]==dp[x-1][y]) x--;
			else {
				sb.append(b[y--]);
				x--;
				max--;
			}
		}
		System.out.println(sb.reverse());
	}
}