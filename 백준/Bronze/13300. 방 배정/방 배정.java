import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		int[][] arr = new int[2][7];
		for(int i = 0;i<n;i++) {
			arr[sc.nextInt()][sc.nextInt()]++;
		}
		for(int i = 1;i<=6;i++) {
			if(arr[0][i]!=0) ans += (arr[0][i]+k-1)/k;
			if(arr[1][i]!=0) ans += (arr[1][i]+k-1)/k;
		}
		System.out.print(ans);
	}
}