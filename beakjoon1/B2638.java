package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2638 {
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] outsideAir;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		outsideAir = new boolean[n][m];
		visited = new boolean[n][m];
		outsideAir[0][0] = true;
		visited[0][0] = true;
		outsidedfs(0,0);
		// 여기까지가 외부공기를 outsideAir에 저장됨
		List<int[]> list;
		int cnt = 0;
		while(cal()) {
			list = new ArrayList<>();
			for(int i = 0; i<n;i++) {
				for(int j = 0; j<m;j++) {
					int count = 0;
					if(arr[i][j]==1) {
						for(int k=0;k<4;k++) {
							int cx = i+dx[k];
							int cy = j+dy[k];
							if(outsideAir[cx][cy]) {
								count++;
							}
						}
					}
					if(count>=2) {
						list.add(new int[] {i,j});
						arr[i][j] = 0;
					}
				}
			}
			
			for(int i = 0; i<list.size();i++) {
				outsideAir[list.get(i)[0]][list.get(i)[1]] = true;
				visited[list.get(i)[0]][list.get(i)[1]] = true;
				outsidedfs(list.get(i)[0],list.get(i)[1]);
			}
			cnt++;
		}
		System.out.println(cnt);
		
	}
	public static boolean cal() {
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<m;j++) {
				if(!outsideAir[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	public static void outsidedfs(int x, int y) {
		for(int i = 0; i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]&&arr[cx][cy]==0) {
				outsideAir[cx][cy] = true;
				visited[cx][cy] = true;
				outsidedfs(cx,cy);
			}
		}
	}
}
