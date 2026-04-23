import java.util.*;

class Main{
	public static void main(String[] s) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i= 0;i<n;i++) {
			String a = sc.nextLine();
			System.out.println(a.toLowerCase());
		}
	}
}
