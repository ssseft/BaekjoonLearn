import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		
		String w = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder ch = new StringBuilder();
		
		for(int i = 0;i<w.length();i++) {
			char c = w.charAt(i);
			if(c=='<') {
				sb.append(ch.reverse());
				ch = new StringBuilder();
				for(int j = i;j<w.length();j++) {
					sb.append(w.charAt(j));
					if(w.charAt(j)=='>') {
						i = j;
						break;
					}
				}
			}
			else if(c==' ') {
				sb.append(ch.reverse());
				ch = new StringBuilder();
				sb.append(' ');
			}
			else ch.append(c);
			
		}
		sb.append(ch.reverse());
		System.out.print(sb);
	}
}
