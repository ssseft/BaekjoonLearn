import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		int ans = 0;
		if(a.charAt(0)>='0'&&a.charAt(0)<='9') ans = Integer.parseInt(a)+3;
		if(b.charAt(0)>='0'&&b.charAt(0)<='9') ans = Integer.parseInt(b)+2;
		if(c.charAt(0)>='0'&&c.charAt(0)<='9') ans = Integer.parseInt(c)+1;
		
		if(ans%5==0&&ans%3==0) System.out.println("FizzBuzz");
		else if(ans%3==0) System.out.println("Fizz");
		else if(ans%5==0) System.out.println("Buzz");
		else System.out.println(ans);
	}
}