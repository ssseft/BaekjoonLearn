import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st,st2;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] swi = new int[n+1];
		int[] bul = new int[n+1];
		int[] dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st2.nextToken());
			swi[i] = c;
			bul[s] = i;
		}
		int max = 1;
		
		for(int i = 1;i<=n;i++) {
			dp[i] = 1;
			for(int j = 1;j<i;j++) {
				if(bul[swi[i]]>bul[swi[j]]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for(int i = n;i>=1;i--) {
			if(dp[i]==max) {
				list.add(swi[i]);
				max--;
			}
			if(max==0) break;
		}
		Collections.sort(list);
		
		for(int i = 0;i<list.size();i++) {
			sb.append(list.get(i)+" ");
		}
		System.out.print(sb);
	}
}