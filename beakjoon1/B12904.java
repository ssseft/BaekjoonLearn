package beakjoon1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B12904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String T = sc.nextLine();
		sc.close();
		List<Character> list = new ArrayList<>();
		for(int i = 0; i<T.length();i++) {
			list.add(T.charAt(i));
		}
		while(list.size()!=S.length()) {
			List<Character> new_list = new ArrayList<Character>();
			if(list.get(list.size()-1)=='A') {
				new_list = list;
				new_list.remove(new_list.size()-1);
			}
			else {
				for(int i = list.size()-2;i>=0;i--) {
					new_list.add(list.get(i));
				}
			}
			list = new_list;
		}
		String result = "";
		for(int i= 0; i<list.size();i++) {
			result+=list.get(i);		
		}
		
		if(S.equals(result)) {
			System.out.print(1);
		}
		else {
			System.out.print(0);
		}
	}
}
