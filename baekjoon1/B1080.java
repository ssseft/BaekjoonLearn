package beakjoon1;

import java.util.Scanner;

public class B1080 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			String a = sc.nextLine();
			for(int j =0;j<m;j++) {
				arr[i][j] = a.charAt(j)-'0';
			}
		}
		int[][] arr2 = new int[n][m];
		for(int i = 0;i<n;i++) {
			String a = sc.nextLine();
			for(int j =0;j<m;j++) {
				arr2[i][j] = a.charAt(j)-'0';
			}
		}
		sc.close();
		int cnt = 0;
		if(n<3||m<3) {
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					if(arr[i][j]!=arr2[i][j]) {
						System.out.print(-1);
						return;
					}
				}
			}
			System.out.print(0);
			return;
		}
		for(int i = 1;i<n-1;i++) {
			for(int j =1;j<m-1;j++) {
				if(arr[i-1][j-1]!=arr2[i-1][j-1]) {
					cnt++;
					for(int a = i-1;a<i+2;a++) {
						for(int b = j-1;b<j+2;b++) {
							arr[a][b] = (arr[a][b]+1)%2;
						}
					}
				}
			}
		}
		boolean ch = false;
		for(int i = 0;i<n;i++) {
			for(int j= 0;j<m;j++) {
				if(arr[i][j]!=arr2[i][j]) {
					ch = true;
					break;
				}
			}
			if(ch) break;
		}
		
		if(ch) System.out.print(-1);
		else System.out.print(cnt);
	}
}
