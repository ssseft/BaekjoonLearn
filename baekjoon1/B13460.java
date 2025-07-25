package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13460 {
	static char[][] arr;
	static int n;
	static int m;
	static int result;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static Queue<int[]> q;
	static boolean[][][][] visited;
	static boolean exit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		int[] blues = new int[2];
		int[] reds = new int[2];
		int[] goal = new int[2];
		
		for(int i = 0; i<n;i++) {
			String line = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = line.charAt(j);
				if(arr[i][j]=='B') {
					blues[0] = i;
					blues[1] = j;
				}
				if(arr[i][j]=='R') {
					reds[0] = i;
					reds[1] = j;
				}
				if(arr[i][j]=='O') {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
		visited = new boolean[n][m][n][m];
		q = new LinkedList<>();
		q.add(new int[] {reds[0],reds[1],blues[0],blues[1],0});
		visited[reds[0]][reds[1]][blues[0]][blues[1]] = true;
		exit = false;
		result = -1;
		
		while(!q.isEmpty()&&!exit) {
			int[] c = q.poll();
			if (c[4] >= 10) break;

            for (int i=0;i<4;i++) {
                seq(c[0],c[1],c[2],c[3],i,c[4]);
            }
		}
		
		System.out.print(result);
		
	}
	//dir이 0 1 2 3 위 오른쪽 아래 왼쪽으로 설정
	static void seq(int redx,int redy,int bluex,int bluey, int dir,int cnt) {
		boolean redfirst = false;
		
		if(dir==0) {
			if(redy<bluey) redfirst = true;
		}else if(dir==1) {
			if(redx>bluex) redfirst = true;
		}else if(dir==2) {
			if(redy>bluey) redfirst = true;
		}else {
			if(redx<bluex) redfirst = true;
		}
		
		int[] mvred = new int[2];
		int[] mvblue = new int[2];
		
		if (redfirst) {
            mvred = moving(redx, redy, dir);
            mvblue = moving(bluex, bluey, dir);
        } else {
            mvblue = moving(bluex, bluey, dir);
            mvred = moving(redx, redy, dir);
        }
		
		if (arr[mvblue[0]][mvblue[1]] == 'O') return;
		if (arr[mvred[0]][mvred[1]] == 'O') {
            result = cnt + 1;
            exit = true;
            return;
        }
		int redDist = Math.abs(mvred[0] - redx) + Math.abs(mvred[1] - redy);
        int blueDist = Math.abs(mvblue[0] - bluex) + Math.abs(mvblue[1] - bluey);
		
        if (mvred[0] == mvblue[0] && mvred[1] == mvblue[1]) {
            if (redDist > blueDist) {
                mvred[0] -= dx[dir];
                mvred[1] -= dy[dir];
            } else {
                mvblue[0] -= dx[dir];
                mvblue[1] -= dy[dir];
            }
        }
        
		if(!visited[mvred[0]][mvred[1]][mvblue[0]][mvblue[1]]) {
			visited[mvred[0]][mvred[1]][mvblue[0]][mvblue[1]] = true;
			q.add(new int[] {mvred[0],mvred[1],mvblue[0],mvblue[1],cnt+1});
		}
	}
	
	static int[] moving(int x, int y,int dir) {
		
		int cx = x;
		int cy = y;
		
		while(true) {
			int nx = cx+dx[dir];
	        int ny = cy+dy[dir];
			if (nx<0||ny<0||nx>=n||ny>=m||arr[nx][ny]=='#') {
	            break;
	        }
			cx = nx;
	        cy = ny;
	        if (arr[cx][cy]=='O') {
	            return new int[]{cx, cy};
	        }
		}
		return new int[]{cx,cy};
		
	}
}
