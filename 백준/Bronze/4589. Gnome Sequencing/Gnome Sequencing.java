import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("Gnomes:\n");
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a<b) {
				if(b<c) {
					sb.append("Ordered\n");
				}
				else {
					sb.append("Unordered\n");
				}
			}
			else {
				if(b>c) {
					sb.append("Ordered\n");
				}
				else {
					sb.append("Unordered\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
