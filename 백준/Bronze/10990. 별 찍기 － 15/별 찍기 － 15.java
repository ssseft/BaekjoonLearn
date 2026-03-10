import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] arr = new boolean[n][2*n-1];
		int lidx = n-1;
		int ridx = n-1;
		for(int i = 0;i<n;i++) {
			arr[i][lidx--] = true;
			arr[i][ridx++] = true;
		}
		
		for(int i = 0;i<n;i++) {
			int cnt = 0;
			for(int j = 0;j<2*n-1;j++) {
				if((cnt==1&&i==0)||cnt==2) continue;
				if(arr[i][j]) {
					System.out.print('*');
					cnt++;
				}
				else System.out.print(' ');
			}
			System.out.println();
		}
		
	}
}
