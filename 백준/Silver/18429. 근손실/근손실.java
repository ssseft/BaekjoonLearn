import java.util.Scanner;

public class Main {
	static int[] arr;
	static int cnt,n,k;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[n];
		visited = new boolean[n];
		cnt = 0;
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		recur(0,500);
		
		System.out.print(cnt);
	}
	static void recur(int dep,int val) {
		if(val<500) return;
		if(dep==n) {
			cnt++;
			return;
		}
		
		for(int i = 0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				val += (arr[i]-k);
				recur(dep+1,val);
				val -= (arr[i]-k);
				visited[i] = false;
			}
		}
	}
}
