import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y1 = sc.nextInt();
		int m1 = sc.nextInt();
		int d1 = sc.nextInt();
		int y2 = sc.nextInt();
		int m2 = sc.nextInt();
		int d2 = sc.nextInt();
		if(m1<m2||(m1==m2&&d1<=d2)) System.out.println(y2-y1);
		else System.out.println(y2-y1-1);
		System.out.println(y2-y1+1);
		System.out.println(y2-y1);	
	}
}