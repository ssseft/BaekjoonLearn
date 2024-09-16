package beakjun;
import java.util.*;

public class B1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		sc.close();
		StringTokenizer s = new StringTokenizer(n, " ");
		
		int as = s.countTokens();
		System.out.println(as);
		
	}
}