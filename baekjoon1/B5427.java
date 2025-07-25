package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int i = 0; i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] arr = new char[w][h];
			Queue<int[]> fireQueue = new LinkedList<int[]>();
			Queue<int[]> move = new LinkedList<>();
			
			boolean[][] fire = new boolean[w][h];
			boolean[][] visited = new boolean[w][h];
			int start_x =0;
			int start_y  = 0;
			for(int j = 0; j<h;j++) {
				String s = br.readLine();
				for(int k = 0; k<w;k++) {
					arr[k][j] = s.charAt(k);
					if(arr[k][j] == '*') {
						fireQueue.add(new int[] {k,j});
						fire[k][j] = true;
					}
					if(arr[k][j] == '@') {
						move.add(new int[] {k,j});
						visited[k][j] = true;
						start_x = k;
						start_y = j;
					}
				}
			}
			if(start_x ==0||start_y==0||start_x==w-1||start_y==h-1) {
				sb.append("1\n");
				continue;
			}
			
			int cnt = 1;
			boolean check = false;
			while(true) {
				Queue<int[]> move2 = new LinkedList<>();
				Queue<int[]> fireQueue2 = new LinkedList<int[]>();
				while(!fireQueue.isEmpty()) {
					int[] c = fireQueue.poll();
					for(int a = 0; a<4;a++) {
						int cx = c[0]+dx[a];
						int cy = c[1]+dy[a];
						if(cx>=0&&cy>=0&&cx<w&&cy<h&&(arr[cx][cy]=='.'||arr[cx][cy]=='@')&&!fire[cx][cy]) {
							fire[cx][cy] = true;
							arr[cx][cy] = '*';
							fireQueue2.add(new int[] {cx,cy});
						}
					}
				}
				
				while(!move.isEmpty()) {
					int[] c = move.poll();
					for(int a = 0; a<4;a++) {
						int cx = c[0]+dx[a];
						int cy = c[1]+dy[a];
						if(cx>=0&&cy>=0&&cx<w&&cy<h&&arr[cx][cy]=='.'&&!visited[cx][cy]) {
							visited[cx][cy] = true;
							arr[cx][cy] = '@';
							move2.add(new int[] {cx,cy});
							if(cx ==0||cy==0||cx==w-1||cy==h-1) {
								check = true;
								cnt++;
								break;
							}
						}
					}
					if(check) break;
				}
				if(check) break;
				if(move2.isEmpty()) {
					cnt = -1;
					break;
				}
				
				cnt++;
				move = move2;
				fireQueue = fireQueue2;
			}
			if(cnt==-1) {
				sb.append("IMPOSSIBLE\n");
			}
			else {
				sb.append(cnt+"\n");
			}
		}
		System.out.print(sb.toString().trim());
	}
}
