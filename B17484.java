package beakjun;
import java.util.Scanner;

public class B17484 {
	static int M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for(int i =0; i<N;i++) {
			move(arr,0,i);
		}
		
	}
	
	public static void move(int[][] arr, int a, int b) {
		int[] dx = {-1,0,1};
		int n = 0;
		while(n>=M) {
			
			
			
			
			
		}
		
	}
}
