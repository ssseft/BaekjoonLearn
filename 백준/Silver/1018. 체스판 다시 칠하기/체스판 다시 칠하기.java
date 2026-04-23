import java.util.Scanner;

public class Main {
	public static boolean[][] arr;
	public static int D = 64;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new boolean[N][M];
		
		for(int i =0; i<N; i++) {
			String a = sc.next();
			for(int j =0; j<M; j++) {
				if(a.charAt(j)=='W') {
					arr[i][j]=true;
				}
				else {
					arr[i][j]=false;
				}
			}
		}
		sc.close();
		int widthcount = N-7;
		int heightcount = M-7;
		
		for(int i=0; i<widthcount;i++) {
			for(int j =0;j<heightcount;j++) {
				find(i,j);
			}
		}
		System.out.print(D);
	}
	
	public static void find(int b, int c) {
		int x = b+8;
		int y = c+8;
		int count = 0;
		
		boolean color = arr[b][c];
		
		for(int i =b; i<x;i++) {
			for(int j =c;j<y;j++) {
				if(arr[i][j] != color)
					count++;
				color = (!color);
			}
			color = (!color);
		}
		count = Math.min(count, 64-count);
		D = Math.min(D,count);
	}
}