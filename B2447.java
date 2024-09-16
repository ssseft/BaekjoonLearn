package beakjun;
import java.util.Scanner;

public class B2447 {
	public static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		arr = new boolean[N][N];
		Check(N,0,0);
		for(int i =0; i<N; i++) {
			for(int j =0; j<N;j++) {
				if(!arr[i][j]) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
	}
	public static void Check(int size, int x, int y) {
		if (size == 1) {
            arr[x][y] = true;
            return;
        }
		int newsize = size/3;
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                Check(newsize, x + (newsize*i), y + (newsize*j));
            }
       }	
		
	}
}
