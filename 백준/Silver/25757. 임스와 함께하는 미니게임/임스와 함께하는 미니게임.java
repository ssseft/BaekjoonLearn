import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a = sc.nextLine().trim();
		Set<String> set = new HashSet<>();
		int cnt = 0;
		for(int i=  0;i<n;i++) {
			String b = sc.nextLine();
			if(set.contains(b)) continue;
			cnt++;
			set.add(b);
		}
		if(a.equals("Y")) System.out.print(cnt);
		else if(a.equals("F")) System.out.print(cnt/2);
		else System.out.print(cnt/3);
	}
}
