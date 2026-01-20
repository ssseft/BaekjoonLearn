import java.io.*;
import java.util.*;

public class Main {
	static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) 
			list[i] = new ArrayList<>();
		
		for(int i = 2;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			char t = st.nextToken().charAt(0);
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list[p].add(new int[] {i,t=='S'?0:1,c});
		}
		
		System.out.print(recursion(1));
	}
	static long recursion(int node) {
		long sum = 0;
		for(int[] next : list[node]){
			long c = recursion(next[0]);
			if(c<0) c = 0;
			if(next[1]==0) 
				c += next[2];
			else {
				c -= next[2];
				if(c<0) c = 0;
			}
			sum += c;
		}
		return sum;
	}
}
