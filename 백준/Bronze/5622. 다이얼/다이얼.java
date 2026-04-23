import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.next();
		int ans = l.length()*2;
		for(int i = 0;i<l.length();i++) {
			char c = l.charAt(i);
			if(c>='A'&&c<='C') ans+=1;
			else if(c>='D'&&c<='F') ans+=2;
			else if(c>='G'&&c<='I') ans+=3;
			else if(c>='J'&&c<='L') ans+=4;
			else if(c>='M'&&c<='O') ans+=5;
			else if(c>='P'&&c<='S') ans+=6;
			else if(c>='T'&&c<='V') ans+=7;
			else ans+=8;
		}
		System.out.println(ans);
	}
}
