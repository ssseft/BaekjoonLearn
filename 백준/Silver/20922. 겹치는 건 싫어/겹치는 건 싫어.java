import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] cnt = new int[100001];
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) 
			arr[i] = sc.nextInt();
		
		int max = 0;
		int left = 0;
		int right = 0;
		while(right<n) {
			while(true) {
				if(cnt[arr[right]]>=k||right==n-1) break;
				cnt[arr[right++]]++;
			}
			if(right==n-1) {
				if(cnt[arr[right]]>=k) max = Math.max(max, right-left);
				else max = Math.max(max, right-left+1);
				break;
			}
			else max = Math.max(max, right-left);
			
			while(true) {
				int c = arr[left];
				cnt[c]--;
				left++;
				if(arr[right]==c||left==n-1) break;
			}
		}
		System.out.print(max);
	}
}
