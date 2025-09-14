import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		int s = 0;
		int m = 99;
		boolean r = false;
		for(int i = 0;i<7;i++) {
			int d = c.nextInt();
			if(d%2==1) {
				m = Math.min(m, d);
				s+=d;
				r = true;
			}
		}
		
		if(!r) System.out.print(-1);
		else {
			System.out.println(s);
			System.out.print(m);
		}
	}
}
