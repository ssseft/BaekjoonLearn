import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][3];
		int[] result = new int[n+2];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = n; i >= 1; i--) {
            int nextDay = i + arr[i][1];

            result[i] = Math.max(result[i + 1], nextDay <= n+1 ? arr[i][2] + result[nextDay] : 0);
        }
		System.out.println(result[1]);
		
	}
}
