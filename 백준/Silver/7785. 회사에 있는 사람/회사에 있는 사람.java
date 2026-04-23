import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0; i<n; i++) {
			String name = sc.next();
			String state = sc.next();
			
			if(map.containsKey(name)) {
				map.remove(name);
			}
			else {
				map.put(name, state);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		for(String a: list) {
			System.out.println(a);
		}
	}
}