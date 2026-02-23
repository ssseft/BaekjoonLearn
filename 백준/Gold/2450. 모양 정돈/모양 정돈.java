import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int[] cnt = new int[4];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 1;i<=3;i++) {
			for(int j = 1;j<=3;j++) {
				for(int k = 1;k<=3;k++) {
					if(i==j||j==k||i==k) continue;
					ans = Math.min(ans, cal(i,j,k,cnt,arr));
				}
			}
		}
		
		System.out.print(ans);
	}
	static int cal(int a,int b,int c,int[] cnt,int[] arr) {
		int t = 0;
		int[][] sta = new int[4][4];
		for(int i = 0;i<cnt[a];i++) {
			if(arr[i]==a) continue;
			sta[a][arr[i]]++;
		}
		for(int i = cnt[a];i<cnt[a]+cnt[b];i++) {
			if(arr[i]==b) continue;
			sta[b][arr[i]]++;
		}
		for(int i = cnt[a]+cnt[b];i<n;i++) {
			if(arr[i]==c) continue;
			sta[c][arr[i]]++;
		}
		
		for(int i = 1;i<=3;i++) {
			for(int j = 1;j<=3;j++) {
				if(i==j) continue;
				if(sta[i][j]>0&&sta[j][i]>0) {
					int min = Math.min(sta[i][j], sta[j][i]);
					t += min;
					sta[i][j] -= min;
					sta[j][i] -= min;
				}
			}
		}
		
		for(int i = 1;i<=3;i++) t += sta[i][1]*2;
		
		return t;
	}
}
