import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[m][n];
		sc.nextLine();
		for(int i = 0;i<m;i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		q.add(new int[] {0,0,0});
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			if(c[0]==m-1&&c[1]==n-1) {
				System.out.print(c[2]);
				return;
			}
			
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<m&&cy<n&&!visited[cx][cy]) {
					visited[cx][cy] = true;
					if(arr[cx][cy]=='0') q.add(new int[] {cx,cy,c[2]});
					else q.add(new int[] {cx,cy,c[2]+1});
				}
			}
		}
	}
}