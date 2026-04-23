import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		sc.close();
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 1; i<a.length()-1; i++) {
			for(int j = i+1; j<a.length(); j++) {
				arr.add(getword(a,i,j));
			}
		}
		Collections.sort(arr);
		System.out.print(arr.get(0));
		
	}

	private static String getword(String a, int i, int j) {
		StringBuilder sb = new StringBuilder();
		StringBuilder a1 = new StringBuilder(a.substring(0,i));
		StringBuilder a2 = new StringBuilder(a.substring(i,j));
		StringBuilder a3 = new StringBuilder(a.substring(j));
		sb.append(a1.reverse()).append(a2.reverse()).append(a3.reverse());
		return sb.toString();
	}
}
