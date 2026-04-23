import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		boolean b;
		int c = 0;
		
		
		for( int i = 0; i<10; i++) {
			a[i] = sc.nextInt()%42;
		}
		sc.close();
		
		for(int j =0; j<10; j++) {
			b = false;
			for(int k = j+1; k <10;k++) {
				if(a[j]==a[k]) {
					b = true;
					break;
				}
			}
			if(b == false) {
				c++;
			}
		}
		System.out.print(c);
		
		
	}
}
