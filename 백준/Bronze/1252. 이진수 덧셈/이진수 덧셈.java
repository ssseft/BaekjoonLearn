import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		while(a.length()>b.length()) b = "0"+b;
		while(a.length()<b.length()) a = "0"+a;
		String ans = "";
		int p = 0;
		
		for(int i = a.length()-1;i>=0;i--) {
			int c = p;
			p = 0;
			if(a.charAt(i)=='1'&&b.charAt(i)=='1') {
				p++;
				ans = Integer.toString(c) + ans;
			}
			else if(a.charAt(i)=='0'&&b.charAt(i)=='0') {
				ans = Integer.toString(c) + ans;
			}
			else {
				if(c==1) p++;
				c = (c+1)%2;
				ans = Integer.toString(c) + ans;
			}
		}
		
		if(p==1) {
			ans = "1" + ans;
		}
		while (ans.length() > 1 && ans.charAt(0) == '0') {
		    ans = ans.substring(1);
		}
		System.out.println(ans);
	}
}