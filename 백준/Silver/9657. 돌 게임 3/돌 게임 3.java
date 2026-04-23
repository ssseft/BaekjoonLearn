import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		boolean[] arr = new boolean[N + 1];
		
		arr[1] = false;
		if(N>=2)arr[2] = true;
		if(N>=3)arr[3] = false;
		if(N>=4)arr[4] = false;
		
		
		for(int i = 5; i<=N; i++) {
			if(!arr[i-1] && !arr[i-3] && !arr[i-4])
			{
				arr[i] = true;
			}
		}
		if(arr[N]) {
			System.out.print("CY");
		}
		else {
			System.out.print("SK");
		}
	}
}