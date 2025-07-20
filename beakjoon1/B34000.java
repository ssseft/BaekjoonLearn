package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B34000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[n+1];
		for(int i = 1;i<=n;i++) {
			count[arr[i]]++;
		}
		
		int favcnt = 0;
		boolean[] fav = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c==1) {
				fav[i] = true;
				favcnt+=count[i];
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type==1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(fav[arr[a]])favcnt--;
                count[arr[a]]--;
                
                arr[a] = b;
                count[b]++;
                if(fav[b])favcnt++;
			}
			else {
				int a = Integer.parseInt(st.nextToken());
				if(fav[a])favcnt -= count[a];
	            else favcnt += count[a];
				fav[a] = !fav[a];
			}
			
			int x = Math.min(favcnt, n-favcnt);
			int a = n/2-x;
			int b = n/2-x;
			if(n%2==1) b++;
			
			sb.append((long)a*b+"\n");
		}
		System.out.print(sb.toString());
	}
}
