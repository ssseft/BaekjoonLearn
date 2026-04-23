import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int price = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i =n-1; i>=0;i--) {
			if(price>=arr[i]) {
				int quotient = price/arr[i];
				if(quotient>0) {
					price -= quotient*arr[i];
					count += quotient;
				}
			}
			if(price == 0) {
				break;
			}
		}
		System.out.print(count);
	}
}
