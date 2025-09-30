
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[n][n];
       Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][n][4];
        for(int i =0;i<n;i++) {
            String l = br.readLine();
            for(int j = 0;j<n;j++) {
                arr[i][j] = l.charAt(j);
                if(arr[i][j]=='R') {
                    q.add(new int[] {i,j,0});
                    visited[i][j][0] = true;
                    visited[i][j][1] = true;
                    visited[i][j][2] = true;
                    visited[i][j][3] = true;
                }
            }
        }
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        
        while(!q.isEmpty()) {
            int[] c = q.poll();
            for(int i = 0;i<4;i++) {
                int cx = c[0];
                int cy = c[1];
                while(true) {
                    cx += dx[i];
                    cy += dy[i];
                    if(cx<0||cy<0||cx>=n||cy>=n||visited[cx][cy][i]) break;
                    
                    if(arr[cx][cy]=='K') {
                    	System.out.print(c[2]+1);
                    	return;
                    }
                    else if(arr[cx][cy]=='B') {
                    	break;
                    }
                    else if(arr[cx][cy]=='W') {
                    	visited[cx][cy][i] = true;
                    	q.add(new int[] {cx,cy,c[2]+1});
                    	break;
                    }
                    q.add(new int[] {cx,cy,c[2]+1});
                    visited[cx][cy][i] = true;
                }
            }
        }
        System.out.println(-1);
    }
}