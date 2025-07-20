package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21609 {
	static int n;
	static int m;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	//위 왼 아래 오
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int score = 0;
		boolean[][] visited;
		while(true) {
			visited = new boolean[n][n];
			List<int[]> block = new ArrayList<>();
			List<int[]> block2 = new ArrayList<>();
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(!visited[i][j]&&arr[i][j]>0) {
						block2 = search(i,j,arr[i][j],visited,arr);
						if(block.size()<block2.size()) {
							block = new ArrayList<>(block2);
						}
						else if(block.size()==block2.size()) {
							int cnt = 0;
							int cnt2 = 0;
							for(int k = 0;k<block.size();k++) {
								int[] c = block.get(k);
								int[] c2 = block2.get(k);
								if(arr[c[0]][c[1]]==0) cnt++;
								if(arr[c2[0]][c2[1]]==0) cnt2++;
							}
							if(cnt<=cnt2) {
								block = new ArrayList<>(block2);
							}
						}
						block2.clear();
					}
				}
			}
			if(block.size()<2) break;
			
			score+= Math.pow(block.size(),2);
			for(int i = 0;i<block.size();i++) {
				int[] c=  block.get(i);
				int x = c[0];
				int y = c[1];
				arr[x][y] = -10;
			}
			arr = gravity(arr);
			arr = rotation(arr);
			arr = gravity(arr);
		}
		System.out.print(score);
	}
	static int[][] rotation(int[][] arr){
		int[][] r_arr = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				r_arr[j][i] = arr[i][n-1-j];
			}
		}
		
		return r_arr;
	}
	static int[][] gravity(int[][] arr) {
		int[][] g_arr =  new int[n][n];
		for(int i = 0;i<n;i++) {
			Arrays.fill(g_arr[i], -10);
		}
		
		for(int i = 0;i<n;i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0;j<n;j++) {
				if(arr[j][i]>=0) {
					list.add(arr[j][i]);
				}
				else if(arr[j][i]==-1) {
					int idx = 1;
					for(int k = list.size()-1;k>=0;k--) {
						g_arr[j-idx++][i] = list.get(k);
					}
					g_arr[j][i] = -1;
					list.clear();
				}
			}
			int idx = 1;
			for(int k = list.size()-1;k>=0;k--) {
				g_arr[n-idx++][i] = list.get(k);
			}
		}
		
		
		
		return g_arr;
	}
	static List<int[]> search(int x, int y,int color,boolean[][] visited,int[][] arr){
		List<int[]> block = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		block.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<n&&(arr[cx][cy]==0||arr[cx][cy]==color)&&!visited[cx][cy]) {
					q.add(new int[] {cx,cy});
					visited[cx][cy] = true;
					block.add(new int[] {cx,cy});
				}
			}
		}
		for(int[] c : block) {
			if(arr[c[0]][c[1]]==0) {
				visited[c[0]][c[1]] = false;
			}
		}
		
		return block;
	}
	
}
