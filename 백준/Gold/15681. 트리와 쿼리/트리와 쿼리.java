import java.io.*;
import java.util.*;

public class Main{
	static boolean[] use;
	static int cnt[];
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		cnt = new int[n+1];
		
		for(int i = 0;i<n-1;i++) {
			st=  new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		use =  new boolean[n+1];
		use[r] =  true;
		recur(r);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<w;i++) {
			int c = Integer.parseInt(br.readLine());
			sb.append(cnt[c]+1+"\n");
		}
		
		System.out.print(sb);
		
		
	}
	static int recur(int c) {
		int d = 0;
		for(int next : list[c]) {
			if(use[next]) continue;
			use[next] = true;
			d++;
			d+= recur(next);
		}
		cnt[c] = d;
		return d;
	}
}
