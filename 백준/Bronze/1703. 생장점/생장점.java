import java.util.*;

class Main {
	public static void main(String[] s){
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			if(a==0) break;
			int t = 1;
			for(int i = 0;i<a;i++) {
				int b = sc.nextInt();
				int c = sc.nextInt();
				t *= b;
				t -= c;
			}
			System.out.println(t);
		}
	}
}
