import java.util.*;

public class Main {
	static class cluster {
		int bx,by,rx,ry,cnt;
		String result;
		public cluster(int bx, int by, int rx, int ry, int cnt, String result) {
			this.bx = bx;
			this.by = by;
			this.rx = rx;
			this.ry = ry;
			this.cnt = cnt;
			this.result = result;
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n,m;
	static char[][] arr;
	static boolean[][][][] visited;
	static boolean red,blue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		int redx = 0;
		int redy = 0;
		int bluex = 0;
		int bluey = 0;
		arr = new char[n][m];
		for(int i = 0;i<n;i++) {
			String l = sc.nextLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = l.charAt(j);
				if(arr[i][j]=='R') {
					redx = i;
					redy = j;
					arr[i][j] = '.';
				}
				if(arr[i][j] == 'B') {
					bluex = i;
					bluey = j;
					arr[i][j] = '.';
				}
			}
		}
		
		visited = new boolean[n][m][n][m];
		
		Queue<cluster> q = new ArrayDeque<>();
		visited[bluex][bluey][redx][redy] = true;
		q.add(new cluster(bluex,bluey,redx,redy,0,""));
		while(!q.isEmpty()) {
			cluster c = q.poll();
			if(c.cnt>=10) continue;
			for(int i = 0;i<4;i++) {
				red = false;
				blue = false;
				int[] next = move(new int[]{c.bx, c.by, c.rx, c.ry}, i);

		        if(blue) continue;

		        int nbx = next[0];
		        int nby = next[1];
		        int nrx = next[2];
		        int nry = next[3];

		        if(red){
		            System.out.println(c.cnt + 1);
		            System.out.println(c.result + pre(i));
		            return;
		        }
		        if(!visited[nbx][nby][nrx][nry]) {
		            visited[nbx][nby][nrx][nry] = true;
		            q.add(new cluster(nbx, nby, nrx, nry, c.cnt+1,c.result+pre(i)));
		        }
			}
		}
		System.out.print(-1);
	}
	static String pre(int dir) {
		if(dir==0) return "R";
		else if(dir==1) return "L";
		else if(dir==2) return "D";
		else return "U";
	}
	static int[] move(int[] ball,int dir){
		int bx = ball[0];
		int by = ball[1];
		int rx = ball[2];
		int ry = ball[3];
		int[] nb,nr;
		if(dir==0) {
			if(by<ry) {
				nr = gravity(new int[] {rx,ry},dir,true);
				nb = gravity(new int[] {bx,by},dir,false);
			}
			else {
				nb = gravity(new int[] {bx,by},dir,false);
				nr = gravity(new int[] {rx,ry},dir,true);
			}
		}
		else if(dir==1) {
			if(by<ry) {
				nb = gravity(new int[] {bx,by},dir,false);
				nr = gravity(new int[] {rx,ry},dir,true);
			}
			else {
				nr = gravity(new int[] {rx,ry},dir,true);
				nb = gravity(new int[] {bx,by},dir,false);
			}
		}
		else if(dir==2) {
			if(bx<rx) {
				nb = gravity(new int[] {bx,by},dir,false);
				nr = gravity(new int[] {rx,ry},dir,true);
			}
			else {
				nr = gravity(new int[] {rx,ry},dir,true);
				nb = gravity(new int[] {bx,by},dir,false);
			}
		}
		else {
			if(bx<rx) {
				nr = gravity(new int[] {rx,ry},dir,true);
				nb = gravity(new int[] {bx,by},dir,false);
			}
			else {
				nb = gravity(new int[] {bx,by},dir,false);
				nr = gravity(new int[] {rx,ry},dir,true);
			}
		}
		
		if (!red&&!blue&&nb[0]==nr[0]&&nb[1]==nr[1]) {
            if(dir==0){ // 오른쪽
                if(by>ry) nr[1]--;
                else nb[1]--;
            } 
            else if(dir==1){// 왼쪽
                if(by<ry) nr[1]++;
                else nb[1]++;
            } 
            else if(dir==2){ // 아래
                if(bx>rx) nr[0]--;
                else nb[0]--;
            } 
            else {
                if(bx<rx) nr[0]++;
                else nb[0]++;
            }
        }

	    return new int[]{nb[0], nb[1], nr[0], nr[1]};
		
		
	}
	static int[] gravity(int[] c, int dir, boolean isRed) {
	    int x = c[0];
	    int y = c[1];

	    while(true){
	        int nx = x+dx[dir];
	        int ny = y+dy[dir];

	        if(nx<0||nx>=n||ny<0||ny>=m) break;
	        if(arr[nx][ny]=='#') break;

	        if(arr[nx][ny]=='O'){
	            if(isRed) red = true;
	            else blue = true;
	            return new int[] {nx, ny};
	        }
	        x = nx;
	        y = ny;
	    }

	    return new int[] {x, y};
	}

}
