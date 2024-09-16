package beakjun;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13913 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(n);
		int[] dp = new int[100001];
		dp[n] = 1;
		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			
			int num = q.poll();
			if(num == k) {
				result = Math.min(result, dp[num]-1);
			}
			if(num-1>=0&&dp[num-1]==0) {
				dp[num-1] = dp[num]+1;
				q.add(num-1);
			}
			if(num+1<=100000&&dp[num+1]==0) {
				dp[num+1] = dp[num]+1;
				q.add(num+1);
			}
			if(num*2<=100000&&dp[num*2]==0) {
				dp[num*2] = dp[num]+1;
				q.add(num*2);
			}
		}
		
		System.out.println(result);
		
		
	}
}
