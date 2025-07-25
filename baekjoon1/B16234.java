package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16234 {
	static int n;
	static int L;
	static int R;
	static int[][] arr;
	static boolean[][] visited;
	static List<List<int[]>> list;
	static boolean check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		while(true) {
			visited = new boolean[n][n];
			list = new ArrayList<>();
			check = false;
			
			for(int i = 0 ;i<n;i++) {
				for(int j = 0; j<n;j++) {
					if(!visited[i][j]) {
						List<int[]> group = new ArrayList<>();
						if(DFS(i,j,group)) {
							list.add(group);
							check = true;
						}
					}
				}
			}
			
			if(!check) {
				break;
			}
			
			int num = list.size();
			
			for(int i = 0; i<num;i++) {
				List<int[]> current = list.get(i);
				int sum = 0;
				
				for(int j = 0; j<current.size();j++	) {
					int[] c = current.get(j);
					sum += arr[c[0]][c[1]];
				}
				
				int everage = sum/current.size();
				
				for(int k = 0; k<current.size();k++) {
					int[] d = current.get(k);
					arr[d[0]][d[1]] = everage;
				}
				
			}
			
			cnt++;
			
		}
		
		System.out.println(cnt);
		
	}
	public static boolean DFS(int x, int y,List<int[]> group) {
		visited[x][y] = true;
		boolean exist = false;
		group.add(new int[] {x,y});
		
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<n&&!visited[cx][cy]
					&&(Math.abs(arr[x][y]-arr[cx][cy]))>=L&&(Math.abs(arr[x][y]-arr[cx][cy]))<=R)
			{
				DFS(cx,cy,group);
				exist = true;
			}
			
		}
		return exist;
	}
}
