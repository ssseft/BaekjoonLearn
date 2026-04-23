import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long s = sc.nextLong();
		sc.close();
		long sum =0;
		int result = 0;
		int i =1;
		while(true) {
			sum += i;
			if(s<sum) {
				result = i-1;
				break;
			}
			i++;
		}
		System.out.print(result);
	}
}