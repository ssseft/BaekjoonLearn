import java.util.*;

public class Main{
	static int total = 0;
	static boolean ch = false;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n==0) {
            System.out.print(0);
            return;
        }
		
		for(int i = 1;i<=10;i++) {
			for(int j = 1;j<=9;j++) {
				recur(j,i,1,Integer.toString(j));
			}
		}
		if(!ch) System.out.print(-1);
	}
	static void recur(int before,int cnt,int c,String num) {
		if(ch) return;
		if(cnt==c) {
			total++;
			if(total==n) {
				System.out.print(Long.parseLong(num));
				ch = true;
			}
			return;
		}
		for(int i = 0;i<before;i++) {
			recur(i,cnt,c+1,num+i);
		}
	}
}