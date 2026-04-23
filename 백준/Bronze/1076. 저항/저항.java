import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		long value = (num(a)*10+num(b))*pow10(num(c));
        System.out.println(value);
	}
	static long pow10(int n) {
		long result = 1;
		for(int i = 0;i<n;i++) {
			result*=10;
		}
		return result;
	}
	static int num(String w) {
		if(w.equals("black")) return 0;
		if(w.equals("brown")) return 1;
		if(w.equals("red")) return 2;
		if(w.equals("orange")) return 3;
		if(w.equals("yellow")) return 4;
		if(w.equals("green")) return 5;
		if(w.equals("blue")) return 6;
		if(w.equals("violet")) return 7;
		if(w.equals("grey")) return 8;
		else return 9;
	}
}
