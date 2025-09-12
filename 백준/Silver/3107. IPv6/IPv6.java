import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String w = sc.next();
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		String c = "";
		for(int i = 0;i<w.length();i++) {
			char cur = w.charAt(i);
			if(cur==':') {
				if(i!=w.length()-1&&w.charAt(i+1)==':') {
					if(c.length()==4) {
						sb.append(c+":");
						c = "";
					}
					else {
						for(int j =0;j<4-c.length();j++) {
							sb.append(0);
						}
						sb.append(c+":");
						c = "";
					}
					int cnt2 = 0;
					for(int j = i+2;j<w.length();j++) {
						if(w.charAt(j)==':') {
							cnt2++;
						}
					}
					for(int j = 0;j<6-cnt-cnt2;j++) {
						sb.append("0000:");
					}
					i++;
				}
				else {
					if(c.length()==4) {
						sb.append(c+":");
						c = "";
					}
					else {
						for(int j =0;j<4-c.length();j++) {
							sb.append(0);
						}
						sb.append(c+":");
						c = "";
					}
				}
				
				cnt++;
			}
			else {
				c+=cur;
			}
		}
		if(c.length()==4) {
			sb.append(c);
		}
		else {
			for(int j =0;j<4-c.length();j++) {
				sb.append(0);
			}
			sb.append(c);
		}
		System.out.print(sb);
	}
}