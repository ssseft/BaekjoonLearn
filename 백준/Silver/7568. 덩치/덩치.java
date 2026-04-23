import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b[][] = new int[a][2];
		for(int i = 0; i<a; i++) {
			b[i][0] = sc.nextInt();
			b[i][1] = sc.nextInt();
		}
		sc.close();
		for(int i =0; i<a; i++) {
			int level = 1;
			for(int j =0; j<a; j++) {
				if(i == j) {
					continue;
				}
				if(b[i][0]<b[j][0]&&b[i][1]<b[j][1]) {
					level ++;
				}
			}
			System.out.print(level+" ");
		}
	}
}