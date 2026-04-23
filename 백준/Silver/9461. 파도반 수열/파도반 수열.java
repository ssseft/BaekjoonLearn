import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		long[] arr = new long[101];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		for(int a =3; a<101; a++){
			arr[a] = arr[a-3]+arr[a-2];
		}
		for(int i =0; i<t; i++) {
			int n = sc.nextInt();
			System.out.println(arr[n-1]);
		}
		
	}
}