import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		String s = sc.nextLine();
		int cH = (c.charAt(0)-'0')*10+(c.charAt(1)-'0');
		int sH = (s.charAt(0)-'0')*10+(s.charAt(1)-'0');
		
		int cM = (c.charAt(3)-'0')*10+(c.charAt(4)-'0');
		int sM = (s.charAt(3)-'0')*10+(s.charAt(4)-'0');

		int cS = (c.charAt(6)-'0')*10+(c.charAt(7)-'0');
		int sS = (s.charAt(6)-'0')*10+(s.charAt(7)-'0');
		
		if(sS<cS) {
			sS+=60;
			sM--;
		}
		if(sM<cM) {
			sM+=60;
			sH--;
		}
		if(sH<cH) sH+=24;
		
		int H = sH-cH;
		int M = sM-cM;
		int S = sS-cS;
		
		String resultH;
		String resultM;
		String resultS;
		if(H<10) resultH = "0"+Integer.toString(H);
		else resultH = Integer.toString(H);
		
		if(M<10) resultM = "0"+Integer.toString(M);
		else resultM = Integer.toString(M);
		
		if(S<10) resultS = "0"+Integer.toString(S);
		else resultS = Integer.toString(S);
		System.out.print(resultH+":"+resultM+":"+resultS);
	}
}