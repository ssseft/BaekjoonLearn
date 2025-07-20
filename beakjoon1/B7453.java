package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7453 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ab = new int[n*n];
		int[] cd = new int[n*n];
		int idx = 0;
		
		for(int i = 0; i<n;i++) {
			for(int j = 0;j<n;j++) {
				ab[idx] = a[i]+b[j];
				cd[idx++] = c[i]+d[j];
			}
		}
		
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		int ABidx = 0;
		int CDidx = n*n-1;
		
		long cnt = 0;
		
		while(ABidx<ab.length&&CDidx>=0) {
			int sum = ab[ABidx]+cd[CDidx];
			
			if(sum==0) {
				long abcnt = 1;
				long cdcnt = 1;
				while(ABidx+1<ab.length&&(ab[ABidx+1]==ab[ABidx])) {
					ABidx++;
					abcnt++;
				}
				while(CDidx-1>=0&&(cd[CDidx-1]==cd[CDidx])) {
					CDidx--;
					cdcnt++;
				}
				cnt+= abcnt*cdcnt;
				ABidx++;
			}
			else if(sum<0) {
				ABidx++;
			}
			else {
				CDidx--;
			}
		}
		System.out.println(cnt);
	}
}
