import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		Queue<int[]> Water = new ArrayDeque<>();
		Queue<int[]> hedgehog = new ArrayDeque<>();
		for(int i = 0;i<n;i++) {
			String l = br.readLine();
			for(int j = 0;j<m;j++) {
				char c = l.charAt(j);
				arr[i][j] = c;
				if(c=='*') {
					Water.add(new int[] {i,j});
				}
				else if(c=='S') {
					hedgehog.add(new int[] {i,j});
				}
			}
		}
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		int time = 1;
		while(!hedgehog.isEmpty()) {
			int wsize = Water.size();
			for(int i = 0;i<wsize;i++) {
				int[] c = Water.poll();
				for(int j = 0;j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]=='.'){
						arr[cx][cy] = '*';
						Water.add(new int[] {cx,cy});
					}
				}
			}
			
			int hsize = hedgehog.size();
			for(int i = 0;i<hsize;i++) {
				int[] c = hedgehog.poll();
				for(int j = 0;j<4;j++) {
					int cx = c[0]+dx[j];
					int cy = c[1]+dy[j];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&(arr[cx][cy]=='.'||arr[cx][cy]=='D')){
						if(arr[cx][cy]=='D') {
							System.out.print(time);
							return;
						}
						arr[cx][cy] = 'S';
						hedgehog.add(new int[] {cx,cy});
					}
				}
			}
			time++;
		}
		System.out.print("KAKTUS");
	}
}
