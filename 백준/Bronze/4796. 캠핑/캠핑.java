import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l==0) break;
			int cnt = (v/p)*l;
			int rem = v- (v/p)*p;
			if(rem>=l) cnt+=l;
			else cnt+=rem;
			
			System.out.println("Case "+idx+++": "+cnt);
		}
	}
}
