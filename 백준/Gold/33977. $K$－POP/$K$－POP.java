import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int quo = (int)Math.ceil(Math.sqrt(k));
		int a=quo,b=1;
		for(int i = quo;i>=1;i--) {
			if(k%i==0) {
				a = Math.max(i, k/i);
				b = Math.min(i, k/i);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(a+b+"\n");
		int idx = 2;
		for(int i = 1;i<=b-1;i++) {
			sb.append(i+" "+idx+++"\n");
			sb.append(i+" "+idx+++"\n");
		}
		for(int i = b;i<=a;i++) {
			sb.append(i+" "+idx+++"\n");
		}
		System.out.print(sb);
	}
}
