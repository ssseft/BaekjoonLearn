package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B2583 {
	static int m;
	static int n;
	static int k;
	static boolean[][] visited;
	static boolean[][] use;
	static List<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		use = new boolean[n][m];
		for(int i =0; i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			calculate(x, y, end_x, end_y);
		}
		
		
		list = new LinkedList<>();
		
		visited = new boolean[n][m];
		for(int i = 0; i<n;i++) {
			for(int j =0; j<m;j++) {
				if(!visited[i][j]&&!use[i][j]) {
					int cnt = dfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		for(int i : list) {
			sb.append(i+" ");
		}
		System.out.print(sb.toString().trim());
	}
	public static int dfs(int x,int y) {
		visited[x][y] = true;
		int count  =1;
		int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
		for(int i =0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!use[cx][cy]&&!visited[cx][cy]) {
				count+=dfs(cx,cy);
			}
		}
		return count;
		
	}
	public static void calculate(int start_x,int start_y,int end_x,int end_y) {
		for(int i = start_x;i<end_x;i++) {
			for(int j = start_y;j<end_y;j++) {
				use[i][j] = true;
			}
		}
	}
	
}