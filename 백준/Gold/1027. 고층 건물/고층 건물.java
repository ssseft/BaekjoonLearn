import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++)
			arr[i] = sc.nextInt();
		
		int[] left = new int[n];
		int[] right = new int[n];
		for(int i = 1;i<n;i++) {
			double standard = Integer.MAX_VALUE;
			int cnt = 0;
			for(int j = i-1;j>=0;j--) {
				double c = (double)(arr[i]-arr[j])/(double)(i-j);
				if(c<standard) {
					standard = c;
					cnt++;
				}
			}
			left[i] = cnt;
		}
		for(int i = 0;i<n-1;i++) {
			double standard = Integer.MIN_VALUE;
			int cnt = 0;
			for(int j = i+1;j<n;j++) {
				double c = (double)(arr[i]-arr[j])/(double)(i-j);
				if(c>standard) {
					standard = c;
					cnt++;
				}
			}
			right[i] = cnt;
		}
		int ans = 0;
		for(int i = 0;i<n;i++) {
			ans = Math.max(ans, left[i]+right[i]);
		}
		
		System.out.print(ans);
	}
}
