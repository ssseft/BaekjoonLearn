import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[9];
		
		
		
		for(int i = 0; i<9; i++) {
			a[i] = sc.nextInt();
		}
		
		int max = a[0];
		
		int b = 0;
		
		for(int j = 1; j<9; j++) {
			if(max<a[j]) {
				max = a[j];
				b = j;
			}
		}
		sc.close();
		System.out.println(max);
		System.out.print(b+1);
		
	}
}
