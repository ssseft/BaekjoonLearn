import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int startspot = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				for(int k = 0;k<n;k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startspot,1<<startspot,0});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[1]==(1<<n)-1) {
				ans = Math.min(ans, c[2]);
				continue;
			}
			
			for(int i = 0;i<n;i++) {
				int value = arr[c[0]][i];
				int node = i;
				if(((1<<node)|c[1])==c[1]) continue;
				int bit = ((1<<node)|c[1]);
				q.add(new int[] {node,bit,c[2]+value});
			}
			
		}
		
		System.out.print(ans);
	}
}