import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i =1;i<=n;i++) {
			String a = sc.nextLine();
			System.out.println(i+". "+a);
		}
	}
}
