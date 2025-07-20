package beakjoon1;
import java.util.Scanner;

public class B1182 {
	static int cnt;
	static int n;
	static int s;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		for(int i =0;i <n;i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0;
		dfs(0,0);
		System.out.print(cnt);
		sc.close();
	}
	public static void dfs(int sum, int start) {
		if(sum==s&&start!=0) {
			cnt++;
		}
		for(int i = start;i<n;i++) {
			dfs(sum+arr[i],i+1);
		}
	}
}
