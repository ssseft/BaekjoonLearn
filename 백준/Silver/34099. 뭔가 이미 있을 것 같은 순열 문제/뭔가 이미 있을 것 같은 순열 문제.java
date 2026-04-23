import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int a = 0;a<t;a++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(k!=1) {
				for(int i =1;i<n;i++) {
					sb.append(i+" ");
				}
				sb.append(n);
			}
			else {
				if(n<=3) sb.append(-1);
				else {
					if(n%2==1) {
						for(int i =n;i>=1;i-=2) {
							sb.append(i+" ");
						}
						for(int i = n-1;i>2;i-=2) {
							sb.append(i+" ");
						}
						sb.append(2);
					}
					else {
						for(int i = n-1;i>=1;i-=2) {
							sb.append(i+" ");
						}
						for(int i = n;i>2;i-=2) {
							sb.append(i+" ");
						}
						sb.append(2);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}