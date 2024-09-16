package beakjun;
import java.util.Scanner;
import java.util.Arrays;

public class B1546 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		float[] b = new float [a];
		float c = 0;
		
		for(int i =0; i<a; i++) {
			b[i] = sc.nextInt();
		}
		
		sc.close();
		Arrays.sort(b);
		for(int i = 0; i<a; i++) {
			b[i] = b[i]/b[a-1]*100;
			c += b[i];
		}
		
		System.out.print(c/a);
		
		
		
		
	}
}