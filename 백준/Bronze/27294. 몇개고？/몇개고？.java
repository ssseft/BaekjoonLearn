import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int s = sc.nextInt();
		
		if(t>11&&t<17&&s==0) System.out.print(320);
		else System.out.print(280);
		
	}
}