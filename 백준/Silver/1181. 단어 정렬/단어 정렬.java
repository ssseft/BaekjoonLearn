import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		sc.nextLine();
		for(int i = 0; i<a; i++) {
			String text = sc.nextLine();
			if(!list.contains(text)) {
				list.add(text);
			}
		}
		
		Collections.sort(list);
		list.sort(Comparator.comparing(String::length));
		for(String arr : list) {
			System.out.println(arr);
		}
	}
}
