import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int cnt = 0;
			for(int j = 0;j<n;j++) {
				String l = sc.next();
				for(int k = 0;k<m;k++) if(l.charAt(k)=='.') cnt++;
			}
			if(cnt%2==1) System.out.println("sewon");
			else System.out.println("pizza");
		}
	}
}
