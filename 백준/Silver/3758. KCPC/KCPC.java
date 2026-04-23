import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		while(d-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] score = new int[n+1][k+1];
			int[] count = new int[n+1];
			int[] lastidx = new int[n+1];
			
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				score[id][num] = Math.max(score[id][num], s);
				count[id]++;
				lastidx[id] = i;
			}
			
			int[] total = new int[n+1];
			for(int i = 1;i<=n;i++) {
				for(int j= 1;j<=k;j++) {
					total[i] += score[i][j];
				}
			}
			List<int[]> list = new ArrayList<>();
			for(int i =1;i<=n;i++) {
				list.add(new int[] {total[i],count[i],lastidx[i],i});
			}
			Collections.sort(list,(a,b)->{
				if(a[0]==b[0]) {
					if(a[1]==b[1]) {
						return a[2]-b[2];
					}
					else {
						return a[1]-b[1];
					}
				}
				else return b[0]-a[0];
			});
			for(int i = 0;i<n;i++) {
				if(list.get(i)[3]==t) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
