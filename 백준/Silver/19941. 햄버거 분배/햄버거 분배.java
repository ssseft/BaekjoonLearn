import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String l = sc.next();
		int cnt = 0;
		
		int idx = 0;
		for(int i = 0;i<n;i++) {
			if(l.charAt(i)=='H') {
				idx = i;
				break;
			}
		}
		
		for(int i = 0;i<n;i++) {
			char c = l.charAt(i);
			if(c=='H') continue;
			
			if(i-k>idx) {
				idx = i-k;
			}
			
			while(idx<n&&idx<i+k) {
				if(l.charAt(idx)=='H') break;
				idx++;
			}
			
			if(idx>=i-k&&idx<=i+k&&idx<n&&l.charAt(idx)=='H') {
				cnt++;
				idx++;
			}
		}
		System.out.print(cnt);
	}
}