import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, String> numToname = new HashMap<>();
		HashMap<String, Integer> nameTonum = new HashMap<>();
		sc.nextLine();
		for(int i =1; i<=n; i++) {
			String name = sc.nextLine();
			numToname.put(i, name);
			nameTonum.put(name, i);
		}
		for(int i = 0; i<m; i++) {
			String query = sc.nextLine();
			if(Character.isDigit(query.charAt(0))) {
				int num = Integer.parseInt(query);
				System.out.println(numToname.get(num));
			}
			else {
				System.out.println(nameTonum.get(query));
			}
		}
		sc.close();
	}
}