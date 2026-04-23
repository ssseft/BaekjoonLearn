import java.util.*;

public class Main {
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sb = new StringBuilder();
		
		for(int i = 0;i<t;i++) {
			int n = sc.nextInt();
			char[] arr = new char[n+1];
			back(1,arr,n);
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void back(int num, char[] arr,int n) {
		if(num==n) {
			char op = '+';
			int total = 0;
			int c = 1;
			for(int i = 1;i<n;i++) {
				if(arr[i]=='+') {
					if(op=='+') total += c;
					else total -= c;
					op = '+';
					c = 0;
				}
				else if(arr[i]=='-') {
					if(op=='+') total += c;
					else total -= c;
					op = '-';
					c = 0;
				}
				else c*=10;
				c+=(i+1);
			}
			if(op=='+') total += c;
			else total -= c;
			if(total==0) {
				sb.append(1);
				for(int i = 1;i<n;i++) {
					sb.append(arr[i]);
					sb.append((i+1));
				}
				sb.append("\n");
			}
			return;
		}
		
		arr[num] = ' ';
		back(num+1,arr,n);
		arr[num] = '+';
		back(num+1,arr,n);
		arr[num] = '-';
		back(num+1,arr,n);
		
	}
}
