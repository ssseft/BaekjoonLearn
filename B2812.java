package beakjun;
import java.util.Scanner;

public class B2812 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		String num = sc.nextLine();
		StringBuilder result = new StringBuilder();
		sc.close();
		for (int i=0;i<n;i++) {
            char c = num.charAt(i);
            while (k>0&&result.length()>0&&result.charAt(result.length()-1)<c) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(c);
        }
		while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }
		System.out.print(result.toString());
	}
}