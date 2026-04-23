import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] s = new boolean[101];
		for(int i = 0;i<n;i++) s[sc.nextInt()] = true;
		int cnt = 0;
		for(int i = 0;i<101;i++) if(s[i]) cnt++;
		System.out.print(n-cnt);
	}
}
