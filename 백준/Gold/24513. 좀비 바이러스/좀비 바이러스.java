import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) q1.add(new int[] {i,j});
				if(arr[i][j]==2) q2.add(new int[] {i,j});
			}
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int[][] cnt = new int[n][m];
		int seq = 1;
		Queue<int[]> temp = new ArrayDeque<>(); 
		while(!q1.isEmpty()||!q2.isEmpty()) {
			int q1size = q1.size();
			int q2size = q2.size();
			temp.clear();
			
			while(q1size-->0) {
				int[] c = q1.poll();
				for(int i = 0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]==0&&cnt[cx][cy]!=seq) {
						cnt[cx][cy] = seq;
                        temp.add(new int[]{cx, cy});
					}
				}
			}
			
			while(q2size-->0) {
				int[] c = q2.poll();
				for(int i = 0;i<4;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&arr[cx][cy]==0) {
						if(cnt[cx][cy]==seq){ 
					        arr[cx][cy] = 3;
					        cnt[cx][cy] = 0;
					    }
						else{
					        arr[cx][cy] = 2;
					        q2.add(new int[]{cx,cy});
					    }
					}
				}
			}
			
			while(!temp.isEmpty()){
                int[] c = temp.poll();
                int x = c[0];
                int y = c[1];
                if(cnt[x][y]==seq) {
                    arr[x][y] = 1;
                    q1.add(c);
                }
            }
			seq++;
		}
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i =0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr[i][j]==1) a++;
				else if(arr[i][j]==2) b++;
				else if(arr[i][j]==3) c++;
			}
		}
		System.out.print(a+" "+b+" "+c);
	}
}
