import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			for(int j = 0; j<num; j++) {
				String name = sc.next();
				String kind = sc.next();
				if(map.containsKey(kind)) {
					int value = map.get(kind);
					map.put(kind, value+1);
				}else {
					map.put(kind,1);
				}
			}
			int result = 1;
			for(int count : map.values()) {
				result *=(count+1);
			}
			System.out.println(result-1);
		}
	}
}
