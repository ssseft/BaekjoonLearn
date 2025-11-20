import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[] item = new int[n+1];
		int[][] arr = new int[n+1][n+1];
		
		
		for(int i = 1;i<=n;i++) {
			item[i] = sc.nextInt();
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0;i<r;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			arr[s][e] = Math.min(arr[s][e], v);
			arr[e][s] = Math.min(arr[e][s], v);
		}
		
		for(int i = 1; i<n+1;i++) {
        	for(int j = 1; j<n+1;j++) {
        		if(arr[j][i]==Integer.MAX_VALUE) continue;
        		for(int k =1;k<n+1;k++) {
        			if(arr[i][k]==Integer.MAX_VALUE) continue;
        			if(arr[j][i]+arr[i][k]<arr[j][k]) {
        				arr[j][k] = arr[j][i]+arr[i][k];
        			}
        		}
        	}
        }
		
		int max = -1;
		
		for(int i = 1;i<=n;i++) {
			int sum = 0;
			sum+=item[i];
			for(int j = 1;j<=n;j++) {
				if(i==j||arr[i][j]>m) continue;
				sum += item[j];
			}
			max = Math.max(max,sum);
		}
		System.out.print(max);
	}
}