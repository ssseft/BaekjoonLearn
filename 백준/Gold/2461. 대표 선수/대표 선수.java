import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		int[] cnt = new int[n];
		int total = 0;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				list.add(new int[] {Integer.parseInt(st.nextToken()),i});
			}
		}
		
		Collections.sort(list,(a,b)->a[0]-b[0]);
		if(n==1) {
			System.out.print(0);
			return;
		}
		int leftidx = 0;
		int min = Integer.MAX_VALUE;
		cnt[list.get(0)[1]]++;
		total++;
		int rightidx = 0;
		while(rightidx<(n*m-1)) {
			while(total<n&&rightidx<(n*m-1)) {
				rightidx++;
				cnt[list.get(rightidx)[1]]++;
				if(cnt[list.get(rightidx)[1]]==1) total++;
			}
			if(total==n) {
				min = Math.min(list.get(rightidx)[0]-list.get(leftidx)[0], min);
			}
			
			
			cnt[list.get(leftidx)[1]]--;
			if(cnt[list.get(leftidx)[1]]==0) total--;
			leftidx++;
		}
		System.out.print(min);
	}
}
