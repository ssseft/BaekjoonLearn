import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;
        int change = 1000 - n;

        for(int b : coins) {
            count += change/b;
            change %= b;
        }

        System.out.print(count);
	}
}
