package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14442 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String[] map = new String[n];
		
		for(int i = 0;i<n;i++) {
			map[i] = br.readLine();
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0,0});
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int cnt = 0;
		boolean[][][] visited = new boolean[n][m][k+2];
		visited[0][0][0] = true;
		boolean check = false;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0;i<size;i++) {
				int[] c = q.poll();
				int x = c[0];
				int y = c[1];
				
				if(c[0]==n-1&&c[1]==m-1) {
					check = true;
				}
				
				if(c[2]>k) continue;
				
				for(int j = 0;j<4;j++) {
					int cx = x+dx[j];
					int cy = y+dy[j];
					int wcnt = c[2];
					if(cx>=0&&cy>=0&&cx<n&&cy<m) {
						if(map[cx].charAt(cy)=='1') wcnt++;
						if(!visited[cx][cy][wcnt]) {
							q.add(new int[] {cx,cy,wcnt});
							visited[cx][cy][wcnt] = true;
						}
					}
				}
			}
			cnt++;
			if(check) break;
		}
		if(check) {
			System.out.println(cnt);
		}
		else {
			System.out.println(-1);
		}
	}
}
