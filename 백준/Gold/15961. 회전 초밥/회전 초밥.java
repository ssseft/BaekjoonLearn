import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+k];
		int[] cnt = new int[d+1];
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = n;i<n+k;i++) {
			arr[i] = arr[i-n];
		}
		
		int max = 0;
		int kind = 0;
		
		for(int i = 0;i<k;i++) {
			int cur = arr[i];
			if(cnt[cur]==0&&cur!=c) {
				kind++;
				max = Math.max(kind, max);
			}
			cnt[arr[i]]++;
		}
		
		for(int i = k;i<n+k;i++) {
			cnt[arr[i-k]]--;
			if(cnt[arr[i-k]]==0&&arr[i-k]!=c) kind--;
			cnt[arr[i]]++;
			if(cnt[arr[i]]==1&&arr[i]!=c) kind++;
			max = Math.max(max, kind);
		}
		System.out.println(max+1);
	}
}
