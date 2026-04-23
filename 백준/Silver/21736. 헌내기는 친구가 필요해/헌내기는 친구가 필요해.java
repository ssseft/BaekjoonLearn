import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][m+1];
		int startx = -1;
		int starty = -1;
		
		for(int i =1;i<n+1;i++) {
			String a = br.readLine();
			for(int j=0;j<m;j++) {
				if(a.charAt(j)=='X') {
					arr[i][j+1] = 1;
				}
				else if(a.charAt(j)=='I') {
					arr[i][j+1] = 2;
					startx = i;
					starty = j+1;
				}
				else if(a.charAt(j)=='P') {
					arr[i][j+1] = 3;
				}
			}
		}
		//빈공간0 벽은1 도연2 사람 3
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		q.add(new int[] {startx,starty});
		boolean[][] visited = new boolean[n+1][m+1];
		visited[startx][starty] = true;
		int count= 0;
		while(!q.isEmpty()) {
			int[] coordinates = q.poll();
			int x = coordinates[0];
			int y = coordinates[1];
			for(int i =0; i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=1&&ny>=1&&nx<=n&ny<=m&&!visited[nx][ny]) {
					if (arr[nx][ny]!=1) {
                        if (arr[nx][ny]==3) {
                            count++;
                        }
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
				}
			}
		}
		if(count==0) {
			System.out.print("TT");
			return;
		}
		System.out.print(count);
		
	}
}
