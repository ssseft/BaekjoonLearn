import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String n = sc.nextLine();
			if(n.charAt(0)-'0'==0) break;
			int t = 1;
			for(int i = 0;i<n.length();i++) {
				int c = n.charAt(i)-'0';
				if(c==0) t+=5;
				else if(c==1) t+=3;
				else t+=4;
			}
			System.out.println(t);
		}
	}
}