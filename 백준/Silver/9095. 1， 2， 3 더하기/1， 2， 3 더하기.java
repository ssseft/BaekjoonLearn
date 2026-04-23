import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int j = 4; j<11; j++) {
			arr[j] = arr[j-1]+ arr[j-2]+ arr[j-3];
		}
		for(int i = 0; i<N; i++) {
			System.out.println(arr[sc.nextInt()]);
		}
		sc.close();
	}
}
