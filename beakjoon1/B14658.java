package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] star = new int[k][2];
		int max = 0;
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			star[i][0] = x;
			star[i][1] = y;
		}
		
		for(int i = 0;i<k;i++) {
			for(int j =0;j<k;j++) {
				int x = star[i][0];
				int y = star[j][1];
				int cnt = 0;
				for(int s = 0;s<k;s++) {
					int cx = star[s][0];
					int cy = star[s][1];
					if(x<=cx&&cx<=x+l&&y<=cy&&cy<=y+l) cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		
		System.out.print(k-max);
	}
}
