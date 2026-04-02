import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		char[][] arr = new char[n][m];
		sc.nextLine();
		boolean s = false;
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		int[][][] dij = new int[n][m][4];
		for(int i = 0;i<n;i++) {
			for(int j=  0;j<m;j++) {
				Arrays.fill(dij[i][j], Integer.MAX_VALUE);
			}
		}
		
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextLine().toCharArray();
			if(s) continue;
			for(int j = 0;j<m;j++) {
				if(arr[i][j]=='C') {
                    if(s) continue;
					for(int k = 0;k<4;k++) {
						dij[i][j][k] = 0;
						q.add(new int[] {i,j,0,k});
					}
					arr[i][j]='.';
					s = true;
				}
			}
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int dir = c[3];
			int cost = c[2];
			if(arr[x][y]=='C') {
				System.out.print(cost);
				return;
			}
			
			if(dij[x][y][dir]<cost) continue;
			for(int i = 0;i<4;i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<m) {
					if (arr[cx][cy] == '*') continue;
					if(i==dir) {
						if(dij[cx][cy][i]>cost) {
							dij[cx][cy][i] = cost;
							q.add(new int[] {cx,cy,cost,i});
						}
					}
					else {
						if(dij[cx][cy][i]>cost+1) {
							dij[cx][cy][i] = cost+1;
							q.add(new int[] {cx,cy,cost+1,i});
						}
					}
				}
			}
		}
	}
}