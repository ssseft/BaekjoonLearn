import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] field;
	static int empty;
	static List<int[]> list;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 연구소 크기
		m = Integer.parseInt(st.nextToken()); // 바이러스 수
		
		field = new int[n][n];
		list = new LinkedList<>();
		empty = 0;
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<n;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j]==2) {
					list.add(new int[] {i,j});
				}
				else if(field[i][j]==0) empty++;
			}
		}
		int[] arr=  new int[m];
		if(empty==0) {
			System.out.print(0);
			return;
		}
		comb(arr,0,0);
		if(min==Integer.MAX_VALUE) {
			System.out.print(-1);
			return;
		}
		System.out.print(min);
	}
	
	static void comb(int[] c, int depth, int start) {
        if (depth == m) {
            bfs(c);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            c[depth] = i;
            comb(c, depth + 1, i + 1);
        }
    }
	
	static void bfs(int[] c){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int current_empty = empty;
		
		for(int a : c) {
			int[] virus = list.get(a);
			q.add(virus);
			visited[virus[0]][virus[1]] = true;
		}
		int time = 0;
		
		while(!q.isEmpty()) {
			int qsize=  q.size();
			if(current_empty==0) {
				min = Math.min(min,time);
				return;
			}
			for(int i = 0; i<qsize;i++) {
				int[] current = q.poll();
				for(int j = 0; j<4;j++) {
					int cx= current[0]+dx[j];
					int cy= current[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<n&&!visited[cx][cy]&&field[cx][cy]!=1) {
						if(field[cx][cy]==0) {
							current_empty--;
						}
						visited[cx][cy]= true;
						q.add(new int[] {cx,cy});
					}
				}
			}
			time++;
		}
	}
}
