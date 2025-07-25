package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1981 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int n;
	static int[][] arr;
	static int min;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		int left = 0;
		int right = 200;
		min = 200;
		max = 0;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min,arr[i][j]);
				max = Math.max(max,arr[i][j]);
			}
		}
		
		while(left<right) {
			int mid = (left+right)/2;
			if(range(mid)) right = mid;
			else left = mid+1;
		}
		
		System.out.println(left);
		
	}
	static boolean range(int mid) {
		for(int low = min;low<=max;low++) {
			int high = low+mid;
			if(arr[0][0]<low||arr[0][0]>high) continue;
			if(arr[n-1][n-1]<low||arr[n-1][n-1]>high) continue;
			if(cal(low,high)) return true;
		}
		return false;
	}
	static boolean cal(int low,int high) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			if(x==n-1&&y==n-1) {
				return true;
			}
			for(int i = 0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<n&&!visited[cx][cy]) {
					if(arr[cx][cy]<=high&&arr[cx][cy]>=low) {
						visited[cx][cy] = true;
						q.add(new int[] {cx,cy});
					}
				}
			}
		}
		
		return false;
	}
}
