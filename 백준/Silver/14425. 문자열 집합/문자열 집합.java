import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		HashSet<String> hashset = new HashSet<>();
		int count = 0;
		for(int i = 0; i<n; i++) {
			hashset.add(sc.nextLine());
		}
		for(int i = 0; i<m; i++) {
			String word = sc.nextLine();
			if(hashset.contains(word)) {
				count++;
			}
		}
		sc.close();
		System.out.print(count);
	}
}
