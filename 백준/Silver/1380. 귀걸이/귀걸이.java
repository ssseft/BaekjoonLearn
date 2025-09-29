import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 1;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			sc.nextLine();
			String[] arr = new String[n];
			for(int i = 0;i<n;i++) {
				arr[i] = sc.nextLine();
			}
			
			int[] cnt = new int[n];
			
			for(int i = 0;i<2*n-1;i++) {
				int s = sc.nextInt();
				String d = sc.next();
				cnt[s-1]++;
			}
			
			for(int i = 0;i<n;i++) {
				if(cnt[i]==1) {
					System.out.println(idx+++" "+arr[i]);
					break;
				}
			}
		}
	}
}
