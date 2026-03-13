import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb=  new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(i%2==0) {
					sb.append('*');
					if(j!=n-1) sb.append(' '); 
				}
				else sb.append(" *"); 
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}
