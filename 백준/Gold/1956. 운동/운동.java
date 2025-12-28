import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		int[][] arr = new int[v+1][v+1];
		for(int i = 1;i<=v;i++) {
			Arrays.fill(arr[i], 100000000);
		}
		int min = 100000000;
		
		for(int i = 0;i<e;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int value = sc.nextInt();
			arr[start][end] = value;
		}
		
		for(int i = 1;i<=v;i++) {
			for(int j = 1;j<=v;j++) {
				for(int k = 1;k<=v;k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}
		
		for(int i = 1;i<=v;i++) {
			min = Math.min(min, arr[i][i]);
		}
		if(min==100000000)
			System.out.print(-1);
		else
			System.out.print(min);
	}
}
