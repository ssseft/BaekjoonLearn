import java.util.*;
class Main{
	public static void main(String[]a) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cnt = new int[10];
		int d = 1;
		while(n/d>0){
			int high = n/(d*10);
			int cur = (n/d)%10;
			int low = n%d;
			for(int i = 0;i<10;i++) cnt[i] += high*d;
			for(int i = 0;i<cur;i++) cnt[i] += d;
			cnt[cur] += low+1;
			cnt[0] -= d;
			d*=10;
		}
		for(int i = 0;i<10;) System.out.print(cnt[i++]+" ");
	}
}