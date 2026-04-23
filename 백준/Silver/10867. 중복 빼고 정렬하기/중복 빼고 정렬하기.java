import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		TreeSet<Integer> t = new TreeSet<>();
		for(int i = 0; i<n;i++) {
			t.add(sc.nextInt());
		}
		sc.close();
		for(Integer num : t) {
			System.out.print(num+" ");
		}
		
		
	}
}
