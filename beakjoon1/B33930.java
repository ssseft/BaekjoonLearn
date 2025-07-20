package beakjoon1;

import java.util.Scanner;

public class B33930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int[][] arr = new int[n+1][n+1];
		int idx = n+1;
		while(idx-->0) {
			int cnt = idx;
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=i;j++) {
					if(cnt==0||arr[i][j]!=0) continue;
					
					if(i>1) {
						if(j>1) {
							if(arr[i-1][j-1]==idx) continue;
							if(arr[i][j-1]==idx) continue;
						}
						if(j<i) {
							if(arr[i-1][j]==idx) continue;
							if(arr[i][j+1]==idx) continue;
						}
					}
					if(i<n) {
						if(arr[i+1][j]==idx) continue;
						if(arr[i+1][j+1]==idx) continue;
					}
					arr[i][j] = idx;
					cnt--;
				}
			}
		}
		if(n==1) {
			System.out.println(1);
			return;
		}
		if(n<4) {
			System.out.print(-1);
			return;
		}
		if(n==4) {
			System.out.println("4");
			System.out.println("3 1");
			System.out.println("2 4 3");
			System.out.println("4 3 2 4");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=i;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
