import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		boolean[] is = new boolean[10000001];
		for(int i = 2;i<=Math.sqrt(10000000);i++) {
			if(is[i]) continue;
			for(int j = i*i;j<=10000000;j+=i) is[j] = true;	
		}
		long cnt = 0;

        for(int i=2; i<=Math.sqrt(b);i++) {
            if(is[i]) continue;
            long v =(long)i*i;
            while(v<=b){
                if(v>=a) cnt++;
                if (v>b/i) break;
                v*= i;
            }
        }
		System.out.print(cnt);
		
	}
}
