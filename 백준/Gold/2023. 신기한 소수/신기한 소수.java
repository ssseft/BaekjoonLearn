import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		print(1,2);
		print(1,3);
		print(1,5);
		print(1,7);
		
		System.out.print(sb.toString());
	}
	static void print(int cnt,int num) {
		if(cnt==n) {
			sb.append(num+"\n");
			return;
		}
		
		for(int i = 1;i<=9;i+=2) {
			int next = num*10+i;
			boolean po =  true;
			for(int j =2;j<=Math.sqrt(next);j++) {
				if(next%j==0) {
					po = false;
					break;
				}
			}
			if(po)print(cnt+1,next);
			
		}
		
	}
}
