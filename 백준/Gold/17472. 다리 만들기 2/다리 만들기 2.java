import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 1;
		visited = new boolean[n][m];
		q = new LinkedList<>();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] {i,j});
					arr[i][j] = idx;
					dfs(idx++);
				}
			}
		}
		
		
		list = new ArrayList[idx];
		for(int i= 1;i<idx;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr[i][j]!=0) list[arr[i][j]].add(new int[] {i,j});
			}
		}
		
		int[][] min = new int[idx][idx];
		for(int i= 1;i<idx;i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		for(int i = 1;i<idx;i++) {
			for(int[] d : list[i]) {
				boolean[] ch = new boolean[4];
				int cnt = 1;
				while(d[0]-cnt>=0||d[0]+cnt<n||d[1]-cnt>=0||d[1]+cnt<m) {
					for(int j=0;j<4;j++) {
						if(ch[j]) continue;
						int cx = d[0]+dx[j]*cnt;
						int cy = d[1]+dy[j]*cnt;
						if(!(cx>=0&&cy>=0&&cx<n&&cy<m)) continue;
						
						if(arr[cx][cy]==i) {
							ch[j] = true;
						}
						else if(arr[cx][cy]!=0) {
							ch[j] = true;
							if(cnt>=3) {
								min[i][arr[cx][cy]] = Math.min(cnt-1,min[i][arr[cx][cy]]);
								min[arr[cx][cy]][i] = Math.min(cnt-1, min[arr[cx][cy]][i]);
							}
						}
					}
					cnt++;
					
				}
			}
		}
		
		int cnt = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
		q.add(new int[] {1,0});//node, value
		
		boolean[] use = new boolean[idx];
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(use[c[0]]) continue;
			use[c[0]] = true;
			cnt+=c[1];
			
			for(int i = 1;i<idx;i++) {
				if(c[0]==i||min[c[0]][i]==Integer.MAX_VALUE) continue;
				q.add(new int[] {i,min[c[0]][i]});
			}			
		}
		
		for(int i = 1;i<idx;i++) {
			if(!use[i]) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(cnt);
		
	}
	static void dfs(int idx) {
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]==1&&!visited[cx][cy]) {
					q.add(new int[] {cx,cy});
					arr[cx][cy]=idx;
					visited[cx][cy] = true;
				}
			}
		}
	}
}
