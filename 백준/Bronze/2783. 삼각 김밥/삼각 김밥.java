import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float min = (sc.nextFloat()*1000)/sc.nextFloat();
		int n = sc.nextInt();
		for(int i = 0;i<n;i++) {
			min = Math.min(min, (sc.nextFloat()*1000)/sc.nextFloat());
		}
		
		System.out.printf("%.2f%n", min);
	}
}
