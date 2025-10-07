import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt()-1;
		int j = sc.nextInt();
		int cnt = 0;
		int idx = 1;
		for(int i = 0;i<j;i++) {
			int c = sc.nextInt();
			if(c<idx) {
				cnt += idx-c;
				idx = c;
			}
			else if(idx+m<c){
				cnt += c-idx-m;
				idx = c-m;
			}
		}
		System.out.print(cnt);
	}
}
