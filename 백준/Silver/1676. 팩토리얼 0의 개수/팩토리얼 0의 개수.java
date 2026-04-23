import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int count = 0;
		while (num >= 5) {
            num /= 5;
            count += num;
        }
		
		System.out.print(count);
	}
}