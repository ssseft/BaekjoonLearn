package beakjoon1;
import java.util.Scanner;

public class B10830 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long b = sc.nextLong();
		sc.nextLine();
		long[][] arr= new long[n][n];
		for(int i = 0; i<n;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextLong();
			}
			sc.nextLine();
		}
		sc.close();
		long[][] result = partition(arr,b);
		
		for(int i =0;i<n;i++) {
			for(int j =0; j<n;j++) {
				System.out.print(result[i][j]%1000+" ");
			}
			System.out.println();
		}
		
	}
	public static long[][] partition(long[][] arr,long b){
		if(b==1) {
			return arr;
		}
		if(b%2==1) {
			return multi(arr,partition(arr,b-1));
		}
		else {
			long[][] half = partition(arr,b/2);
			return multi(half,half);
		}
		
	}
	public static long[][] multi(long[][] arr, long[][] result){
		long[][] C = new long[n][n];
		for (int i=0; i<n; i++) {
            for (int j =0; j<n; j++) {
                long num = 0;
                for (int k = 0; k < n; k++) {
                    num += arr[i][k]*result[k][j];
                }
                C[i][j] = num%1000;
            }
        }
		return C;
	}
}
