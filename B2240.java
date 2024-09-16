package beakjun;
import java.util.Scanner;
public class B2240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int w = sc.nextInt();
		int arr[] = new int[t+1];
		int dp[] = new int[t+1];
		arr[0] = 1;
		int index = 0;
		for(int i = 1;i<t+1;i++) {
			arr[i] = sc.nextInt();
			if(arr[i]==arr[i-1]) {
				dp[i] = dp[i-1]+1;
				dp[i-1] = 0;
				index++;
			}
			else {
				dp[i] = 1;
			}
		}
		boolean check = false;
		if(arr[1] == 1) check =true; // 1로 시작하면 true 2로 시작하면 false 시작점은 1임
		
		sc.close();
		int result[] = new int[index+1];
		int a = 0;
		for(int i = 1;i<t+1;i++) {
			if(dp[i]!=0) {
				result[a] = dp[i];
				a++;
			}
		}
		int[] count = new int[index+1];
		int max = 0;
		for(int i =2;i<index+1;i++) {
			
		}
		
		
		
		
	}
}
