import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Integer>[] list = new ArrayList[n+1];
		for(int i =1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		boolean[] v = new boolean[n+1];
		v[1] = true;
		int cnt = 0;
		for(int a : list[1]) {
			if(!v[a]) {
				v[a] = true;
				cnt++;
			}
			for(int b : list[a]) {
				if(!v[b]) {
					cnt++;
					v[b] = true;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
