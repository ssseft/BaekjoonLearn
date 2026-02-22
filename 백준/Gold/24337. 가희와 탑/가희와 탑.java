import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if(a+b>n+1) {
			System.out.print(-1);
			return;
		}
		
		if(a==b) {
			for(int i = 0;i<n+1-(a+b);i++) sb.append(1+" ");
			for(int i = 1;i<=a;i++) sb.append(i+" ");
			for(int i = a-1;i>=1;i--) sb.append(i+" ");
		}
		else if(a>b) {
			for(int i = 0;i<n+1-(a+b);i++) sb.append(1+" ");
			for(int i = 1;i<=a;i++) sb.append(i+" ");
			for(int i = b-1;i>=1;i--) sb.append(i+" ");
		}
		else {
			if(a==1) {
		        sb.append(b+" ");
		        for(int i = 0;i<n-b;i++) sb.append(1+" ");
		        for(int i = b-1;i>=1;i--) sb.append(i+" ");
		    }
			else {
				for(int i = 0;i<n+1-(a+b);i++) sb.append(1+" ");
				for(int i = 1;i<a;i++) sb.append(i+" ");
				sb.append(b+" ");
				for(int i = b-1;i>=1;i--) sb.append(i+" ");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
