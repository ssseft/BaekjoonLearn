package beakjoon1;
import java.util.Scanner;

public class B10162 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		sb.append(t/300+" ");
		t %= 300;
		sb.append(t/60+" ");
		t %= 60;
		if(t%10!=0) {
			System.out.print(-1);
			return;
		}
		sb.append(t/10);
		System.out.print(sb.toString());
	}
}
