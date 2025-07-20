package beakjoon1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B16639 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		sc.close();
		List<Integer> num = new ArrayList<>();
		List<Character> op = new ArrayList<>();
		for(int i = 0; i<n;i++) {
			char c = s.charAt(i);
			if(c>='0'&&c<='9') num.add(c-'0');
			else op.add(c);
		}
		int[][][] dp = new int[n/2+1][n/2+1][2];
		for(int i = 0;i<n/2+1;i++) {
			for(int j = 0;j<n/2+1;j++) {
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MIN_VALUE;
			}
		}
		for(int i = 0;i<n/2+1;i++) {
			dp[i][i][0] = num.get(i);
			dp[i][i][1] = num.get(i);
		}
		//0은 i범위부터 j범위 사이 값의 최솟값
		//1은 i범위부터 j범위 사이 값의 최댓값
		for(int i = 0;i<n/2;i++) {
			int j = i+1;
			dp[i][j][0] = cal(dp[i][i][0],dp[j][j][0],op.get(i));
			dp[i][j][1] = cal(dp[i][i][1],dp[j][j][1],op.get(i));
		}
		for(int d = 2;d<=n/2;d++) {
			for(int i = 0;i<=n/2-d;i++) {
				int j = i+d;
				for(int k = i;k<j;k++) {
					char oper = op.get(k);
					int l = Integer.MAX_VALUE;
					int r = Integer.MIN_VALUE;
					if(oper=='-') {
						l = cal(dp[i][k][0],dp[k+1][j][1],oper);
						r = cal(dp[i][k][1],dp[k+1][j][0],oper);
					}
					else if(oper=='+') {
						l = cal(dp[i][k][0],dp[k+1][j][0],oper);
						r = cal(dp[i][k][1],dp[k+1][j][1],oper);
					}
					else {
						for(int a = 0;a<=1;a++) {
							for(int b = 0;b<=1;b++) {
								l = Math.min(l, cal(dp[i][k][a],dp[k+1][j][b],oper));
								r = Math.max(r, cal(dp[i][k][a],dp[k+1][j][b],oper));
							}
						}
					}
					dp[i][j][0] = Math.min(dp[i][j][0], l);
					dp[i][j][1] = Math.max(dp[i][j][1], r);
				}
			}
		}
		System.out.print(dp[0][n/2][1]);
	}
	static int cal(int a, int b ,char op) {
		if(op=='+') return a+b;
		else if(op=='-') return a-b;
		else return a*b;
	}
}
