import java.util.*;

public class Main {
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int[] zx = {1,0,-1,0};
	static int[] zy = {0,1,0,-1};
	static int n;
	static int[] arr;
	static int[] bead = new int[4];
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		arr = new int[n*n];
		int idx = 3;
		int x = n/2;
		int y = n/2-1;
		int cnt = 0;
		int len = 2;
		arr[1] = map[x][y];
		x++;
		arr[2] = map[x][y];
		int d = 1;
		while(x>=0&&y>=0&&x<n&&y<n) {
			for(int i = 0;i<len;i++) {
				x += zx[d];
				y += zy[d];
				if(x<0||y<0||x>=n||y>=n) break;
				arr[idx++] = map[x][y];
			}
			if(++cnt==2) {
				cnt = 0;
				len++;
			}
			d = (d+1)%4;
		}
		
		for(int i = 0;i<m;i++) {
			int dir = sc.nextInt();
			int dep = sc.nextInt();
			destroy(dir,dep);
			moveAndexplode();
			change();
		}
		System.out.print(bead[1]+bead[2]*2+bead[3]*3);
	}
	static void change() {
		Queue<Integer> q = new ArrayDeque<>();
		int curNum = arr[1];
		int cnt = 0;
		for(int i = 1;i<n*n;i++) {
			if(arr[i]==0) break;
			if(arr[i]==curNum) cnt++;
			else {
				q.add(cnt);
				q.add(curNum);
				cnt = 1;
				curNum = arr[i];
			}
		}
		q.add(cnt);
		q.add(curNum);
		int idx = 1;
		while(!q.isEmpty()&&idx<n*n) arr[idx++] = q.poll();
		for(int i = idx;i<n*n;i++) arr[i] = 0;
	}
	static void moveAndexplode() {
		Queue<Integer> q = new ArrayDeque<>();
		while(true) {
			q.clear();
			int curNum = -1;
			int cnt = 0;
			int startidx = -1;
			boolean d = false;
			for(int i = 1;i<n*n;i++) {
				if(arr[i]==0) continue;
				q.add(arr[i]);
			}
			int idx = 1;
			while(!q.isEmpty()&&idx<n*n) arr[idx++] = q.poll();
			
			for(int i = idx;i<n*n;i++) arr[i] = 0;
			
			for(int i = 1;i<n*n;i++) {
				if(arr[i]==0) break;
				if(arr[i]==curNum) cnt++;
				else {
					if(cnt>=4) {
						for(int j = startidx;j<startidx+cnt;j++) {
							arr[j] = 0;
						}
						bead[curNum] += cnt;
						d = true;
					}
					startidx = i;
					curNum = arr[i];
					cnt = 1;
				}
			}
			
			if(cnt>=4) {
				for(int i = startidx;i<startidx+cnt;i++) arr[i] = 0;
				bead[curNum] += cnt;
				d = true;
			}
			
			if(!d) break;
		}
		
	}
	static void destroy(int dir,int dep) {
		int s = 0;
		if(dir==1) s=7;
		if(dir==2) s=3;
		if(dir==3) s=1;
		if(dir==4) s=5;
		int lastnum = s;
		int gap = s;
		for(int i = 0;i<dep;i++) {
			arr[s] = 0;
			gap += 8;
			lastnum += gap;
			s = lastnum;
		}
	}
}
