import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int t = a.nextInt();
		while(t-->0) {
			int q = a.nextInt();
			int w = a.nextInt();
			if(q<w) System.out.println("NO BRAINS");
			else System.out.println("MMM BRAINS");
		}
	}
}
