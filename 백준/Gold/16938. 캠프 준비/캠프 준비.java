import java.util.*;

public class Main {
	static int ans,n,l,r,x;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		x = sc.nextInt();
		ans = 0;
		
		arr = new int[n];
		for(int i =0;i<n;i++) arr[i] = sc.nextInt();
		
		recur(0,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		System.out.print(ans);
	}
	static void recur(int idx,int sum,int cnt,int min,int max) {
		if(idx==n) {
			if(sum>=l&&sum<=r&&cnt>=2&&(max-min)>=x) {
				ans++;
			}
			return;
		}
		recur(idx+1,sum,cnt,min,max);
		
		recur(idx+1,sum+arr[idx],cnt+1,Math.min(min, arr[idx]),Math.max(max, arr[idx]));
	}
}
	