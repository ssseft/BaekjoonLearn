import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cnt = new int[10];
		int d = 1;
		
		while(n/d>0) {
			int high = n/(d*10);
			int cur = (n/d)%10;
			int low = n%d;
			//여기서 high는 cur보다 높은 자리, low는 낮은 자리
			//예를들어 5352에서 cur이 3이라면 high는 5, low는 52
			
			for(int i = 0;i<10;i++) {
				cnt[i] += high*d;
				//기본 자리수 숫자 더하기
			}
			
			//보정
			for(int i = 0;i<cur;i++) {
				cnt[i] += d;	
			}
			cnt[cur] += low+1; //0을 포함해서 +1
			
			
			cnt[0] -= d; // cur이 0일경우에도 처리해줘야되서
			
			d*=10;
		}
		
		for(int i = 0;i<10;i++) {
			System.out.print(cnt[i]+" ");
		}
	}
}