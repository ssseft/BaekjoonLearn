package beakjun;
import java.util.Scanner;

public class B1312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		
		int rem = a % b;
        int result = 0;
        for (int i = 0; i < n; i++) { 
            rem *= 10;
            result = rem / b;
            rem %= b;
        }

        System.out.print(result);
	}
}