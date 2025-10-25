import java.io.*;
import java.util.*;

public class Main {
	static boolean[] include,circle;
	static int cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int j =1;j<=n;j++) arr[j] = Integer.parseInt(st.nextToken());
			cnt = n;
			include = new boolean[n+1];
			circle = new boolean[n+1];
			for(int j = 1;j<=n;j++) {
				if(!include[j]) {
					recur(j);
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
	}
	static void recur(int curNum) {
		circle[curNum] = true;
		int c = arr[curNum];
		
		if(!circle[c]) recur(c);
		else if(!include[c]){
			int next = c;
			cnt--;
			next = arr[next];
			while(next!=c) {
				cnt--;
				next = arr[next];
			}
		}
		include[curNum] = true;
	}
}