import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[8];
		String b ="";
		
		for( int i = 0; i<8; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		for(int j = 0; j<7;j++) {
			if(a[j] == a[j+1]-1) 
				b = "ascending";

			else if(a[j] == a[j+1]+1) 
				b = "descending";
			
			else {
				b = "mixed";
				break;
			}
		}
		System.out.print(b);
	}
}
