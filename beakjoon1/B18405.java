package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B18405 {
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) q.add(new int[] {i,j,arr[i][j]});
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		
		int cnt = 0;
		while(cnt<s&&!q.isEmpty()) {
			q = dfs(q);
			cnt++;
			if(arr[x-1][y-1]!=0) break;
		}
		
		System.out.print(arr[x-1][y-1]);
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static PriorityQueue<int[]> dfs(PriorityQueue<int[]> q){
		PriorityQueue<int[]> q2 = new PriorityQueue<>((a,b)->a[2]-b[2]);
		int size = q.size();
		for(int i = 0;i<size;i++) {
			int[] c = q.poll();
			
			for(int j = 0;j<4;j++) {
				int cx = c[0]+dx[j];
				int cy = c[1]+dy[j];
				if(cx>=0&&cy>=0&&cx<n&&cy<n&&arr[cx][cy]==0) {
					arr[cx][cy] = c[2];
					q2.add(new int[] {cx,cy,c[2]});
				}
			}
		}
		return q2;
	}
}
