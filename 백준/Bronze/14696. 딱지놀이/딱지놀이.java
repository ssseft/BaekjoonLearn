import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int[] acnt = new int[5];
			int anum = Integer.parseInt(st.nextToken());
			
			for(int j = 0;j<anum;j++) {
				acnt[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int[] bcnt = new int[5];
			int bnum = Integer.parseInt(st.nextToken());
			
			for(int j = 0;j<bnum;j++) {
				bcnt[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean awin = false;
			boolean ch = false;
			for(int j = 4;j>=1;j--) {
				if(acnt[j]==bcnt[j]) continue;
				ch = true;
				if(acnt[j]>bcnt[j]) {
					awin = true;
					break;
				}
				else {
					awin = false;
					break;
				}
			}
			
			if(!ch) sb.append("D\n");
			else {
				if(awin) sb.append("A\n");
				else sb.append("B\n");
			}
		}
		
		System.out.print(sb);
		
		
	}
}
