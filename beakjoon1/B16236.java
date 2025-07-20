package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
	static int n;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int cnt;
	static int result;
	static int size;
	static int stack;
	static int current_x;
	static int current_y;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		current_x =0;
		current_y =0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					current_x = i;
					current_y = j;
				}
			}
		}
		stack = 0;
		cnt = 0;
		size = 2;
		while(true) {
			int[] C = search(current_x,current_y);
			if(C[0] == -1) {
				break;
			}
			current_x = C[0];
			current_y = C[1];
		}
		System.out.println(cnt);
	}
	public static int[] search(int x, int y) {
		boolean[][] visited = new boolean[n][n];
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{x, y});
	    visited[x][y] = true;
	    int[][] num = new int[n][n];
		int[] minxy = new int[] {21,21};
		boolean check = false;
		List<int[]> list = new ArrayList<>();
		while(!q.isEmpty()) {
			int Qsize = q.size();
			for(int i = 0; i<Qsize;i++) {
				int[] c = q.poll();
				for(int j = 0; j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<n&&!visited[cx][cy]&&size>=arr[cx][cy]) {
						visited[cx][cy]= true;
						num[cx][cy] = num[c[0]][c[1]]+1;
						q.add(new int[] {cx,cy});
						if(arr[cx][cy]!=0&&arr[cx][cy]<size) {
							list.add(new int[] {cx,cy});
							check = true;
						}
					}
					
				}
				
			}
			if(check) break;
		}
		if(check) {
			int Lsize = list.size();
			for(int i = 0; i<Lsize;i++) {
				int[] cu = list.get(i);
				if(cu[0]<minxy[0]) {
					minxy[1] = cu[1];
					minxy[0] = cu[0];
				}
				else if(cu[0]==minxy[0]&&cu[1]<minxy[1]) {
					minxy[1] = cu[1];
					minxy[0] = cu[0];
				}
				
			}
		}
		
		
		if(check) {
			arr[minxy[0]][minxy[1]] = 9;
			arr[x][y] = 0;
			cnt+=num[minxy[0]][minxy[1]];
			stack++;
			if(stack==size) {
				size++;
				stack = 0;
			}
			return minxy;
		}
		
		return new int[] {-1,-1};
	}
}
