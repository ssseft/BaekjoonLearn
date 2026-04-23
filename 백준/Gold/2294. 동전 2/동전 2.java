import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			set.add(sc.nextInt());
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(set);;
		int[] dp = new int[k+1];
		Arrays.fill(dp,100001);
		dp[0] = 0;
		for(int i =0; i<list.size();i++) {
            for(int j = list.get(i); j<k+1;j++) {
                dp[j] = Math.min(dp[j], dp[j-list.get(i)]+1);
            }
        }
		
		if(dp[k]>=100001) {
			System.out.print(-1);
		}
		else {
			System.out.print(dp[k]);
		}
		
	}
}