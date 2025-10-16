import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,h;
	static int[][] arr;
	static int[] c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		h = (int) Math.ceil(Math.log(n)/Math.log(2));
		arr = new int[n+1][h+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i<=h;i++) {
			for(int j = 1;j<=n;j++) {
				int previous = arr[j][i-1];
				arr[j][i] = arr[previous][i-1];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		c = new int[n+1];
		for(int i = 1;i<=n;i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = 2*n;
		int ans = -1;
		while(left<=right) {
			int mid = (left+right)/2;
			int total = cal(mid);
			if(total>=k) {
				ans = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		System.out.print(ans);
	}
	static int cal(int mid) {
		int max = 0;
		int[] cnt = new int[n+1];
		mid--;
		for(int i = 1;i<=n;i++) {
			int cur = c[i];
	        int b = 0;
	        int step = mid;
	        while(step > 0) {
	            if((step & 1) == 1) cur = arr[cur][b];
	            step >>= 1;
	            b++;
	        }
			cnt[cur]++;
		}
		
		for(int i = 1;i<=n;i++) {
			max = Math.max(max, cnt[i]);
		}
		
		return max;
	}
}
