package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static int cnt;
	static boolean[][] cheese;
	static Queue<int[]> q;
	static Queue<int[]> q2;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		cheese = new boolean[n][m];
		cnt = 0;
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c==1) {
					cheese[i][j] = true;
					cnt++;
				}
			}
		}
		list.add(cnt);
		visited = new boolean[n][m];
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		while(!q.isEmpty()) { // 초기 노출된 공기들
			int[] c = q.poll();
			for(int i = 0; i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]) {
					
					visited[cx][cy] = true;
					if(!cheese[cx][cy]) {
						q.add(new int[] {cx,cy});
					}
					else {
						q2.add(new int[] {cx,cy});
					}
				}
			}
		}
		int time = 0;
		
		while(cnt!=0) {
			q2 = BFS();
			time++;
		}
		
		System.out.println(time);
		if(time==1) {
			System.out.println(list.get(0));
		}
		else {
			System.out.print(list.get(list.size()-2));
		}
		
	}
	static Queue<int[]> BFS() {
		Queue<int[]> q3 = new LinkedList<>();
		while(!q2.isEmpty()) {
			int[] c = q2.poll();
			if(cheese[c[0]][c[1]]) {
				cheese[c[0]][c[1]] = false;
				cnt--;
			}
			
			for(int i = 0; i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(!visited[cx][cy]) {
					visited[cx][cy] = true;
					if(cheese[cx][cy]) {
						q3.add(new int[] {cx,cy});
					}
					else {
						q2.add(new int[] {cx,cy});
					}
				}
			}
		}
		list.add(cnt);
		return q3;
	}
}
