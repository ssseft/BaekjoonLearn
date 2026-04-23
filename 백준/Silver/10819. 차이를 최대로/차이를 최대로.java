import java.util.*;

public class Main {
	static int n,max;
	static int[] arr,D;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		visit = new boolean[n];
		D = new int[n];
		max = -123123;
		recur(0);
		System.out.print(max);
	}
	static void recur(int cnt) {
		if(cnt==n) {
			int total = 0;
			for(int i = 0;i<n-1;i++) {
				total += Math.abs(arr[D[i]]-arr[D[i+1]]);
			}
			max = Math.max(max, total);
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				D[cnt] = i;
				recur(cnt+1);
				D[cnt] = -1;
				visit[i] = false;
			}
		}
	}
}