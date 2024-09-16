package beakjun;
import java.util.Scanner;

public class B1205_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long newScore= sc.nextInt();
		int p = sc.nextInt();
		int result = -1;
		if(n==0) {
			System.out.print(1);
			return;
		}
		long[] scores = new long[n+1];
		for (int i = 1; i <= n; i++) {
			scores[i] = sc.nextLong();
		}
		
		for(int i= 1; i<n+1;i++) {
			if (scores[i]<newScore) {
				result = i;
				break;
			} 
			else if(scores[i]==newScore) {
				result =i;
				if(scores[n]==newScore) {
					System.out.print(-1);
					return;
				}
				break;
			}
		}
		if (result > p) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
	}
}