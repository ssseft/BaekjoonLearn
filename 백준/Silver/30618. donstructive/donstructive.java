import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i = 0;i<n/2;i++) {
			sb.append(i*2+1+" ");
		}
		if(n%2==1) sb.append(n+" ");
		for(int i = n/2;i>0;i--) {
			sb.append(i*2+" ");
		}
		System.out.print(sb);
	}
}
