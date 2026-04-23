import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] add = new int[n+1];
		st = new StringTokenizer(br.readLine());
		add[1] = Integer.parseInt(st.nextToken());
		for(int i = 2;i<=n;i++) {
			int c = Integer.parseInt(st.nextToken());
			add[i] = add[i-1]+c;
		}
		
		StringBuilder sb=  new StringBuilder();
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(add[e]-add[s-1]+"\n");
		}
		System.out.println(sb.toString());
		
	}
}
