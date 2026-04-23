import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			List<int[]> list = new ArrayList<>();
			
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new int[] {s,e});
			}
			
			Collections.sort(list,(a,b)->{
				if(a[1]==b[1]) return a[0]-b[0];
				else return a[1]-b[1];
			});
			
			int cnt = 0;
			boolean[] used = new boolean[n+1];
			for(int[]c : list) {
				for(int i = c[0];i<=c[1];i++) {
					if(!used[i]) {
						used[i] = true;
						cnt++;
						break;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
}