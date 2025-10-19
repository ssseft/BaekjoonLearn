import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[m][2];
		for(int i = 0;i<m-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
		}
		
		int lasttime = sc.nextInt();

		int idx = 0;
		int time = 0;
		int[] use = new int[n];
		while(true) {
			for(int i = 0;i<n;i++) {
				if(use[i]<=time) use[i] = 0;
				else break;
			}
			
			int lastidx = 0;
			for(int i = n-1;i>=0;i--) {
				if(use[i]!=0) {
					lastidx = i+1;
					break;
				}
			}
			
			for(int i = lastidx;i<n;i++) {
				if(idx>=m-1) break;
				if(arr[idx][0]<=time) {
					use[i] = time + arr[idx++][1];
				}
				
				else break;
			}
			
			if(use[n-1]==0&&lasttime<=time) break;
			time++;
		}
		int ans = 0;
		for(int i = n-1;i>=0;i--) {
			if(use[i]!=0) {
				ans = i+1;
				break;
			}
		}
		System.out.print(ans+1);
	}
}