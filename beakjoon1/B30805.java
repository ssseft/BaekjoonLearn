package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B30805 {
	static int A[];
	static int B[];
	static int[][] dp;
	static int a_len;
	static int b_len;
	static int max;
	static int index;
	static List<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		a_len = Integer.parseInt(br.readLine());
		A = new int[a_len];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<a_len;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		b_len = Integer.parseInt(br.readLine());
		B = new int[b_len];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<b_len;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[a_len+1][b_len+1];
		list = new LinkedList<>();
		max = 0;
		index = 0;
		LCS();
		
		
	}
	
	public static void LCS() {
		for(int i = 1; i<=a_len;i++) {
			for(int j =1; j<=b_len;j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
					list.add(A[i-1]);
					if(A[i-1]>max) {
						max = A[i-1];
						index = i-1;
					}
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
	}
	
}
