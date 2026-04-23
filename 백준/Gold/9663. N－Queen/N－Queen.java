import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int n;
	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		count = 0;
		sc.close();
		
		arr = new int[n];
		dfs(0);
		System.out.print(count);
		
	}
	public static void dfs(int depth) {
		if(depth == n) {
			count++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				dfs(depth+1);
			}
		}
	}
	public static boolean possible(int col) {
		for(int i =0; i<col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			}
			else if(Math.abs(col-i)== Math.abs(arr[col]-arr[i])) {
				return false;
			}
		}
		return true;
	}
}
