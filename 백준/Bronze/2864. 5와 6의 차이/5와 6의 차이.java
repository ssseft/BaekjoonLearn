import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int max = 0;
		int min = 0;
		for(int i = 0;i<a.length();i++) {
			char c = a.charAt(a.length()-1-i);
			if(c=='5') max += Math.pow(10, i)*6;
			else max += Math.pow(10, i)*(c-'0');
		}
		for(int i = 0;i<a.length();i++) {
			char c = a.charAt(a.length()-1-i);
			if(c=='6') min += Math.pow(10, i)*5;
			else min += Math.pow(10, i)*(c-'0');
		}
		for(int i = 0;i<b.length();i++) {
			char c = b.charAt(b.length()-1-i);
			if(c=='5') max += Math.pow(10, i)*6;
			else max += Math.pow(10, i)*(c-'0');
		}
		for(int i = 0;i<b.length();i++) {
			char c = b.charAt(b.length()-1-i);
			if(c=='6') min += Math.pow(10, i)*5;
			else min += Math.pow(10, i)*(c-'0');
		}
		System.out.print(min+" "+max);
	}
}
