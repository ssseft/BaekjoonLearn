import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(int tc = 1;tc<=t;tc++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[n][n];
        	
        	Queue<int[]> q = new ArrayDeque<>();;
        	for(int i = 0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0;j<n;j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	int[][][] cnt = new int[n][n][n+2];
        	boolean[][] visited;
        	for(int i =0;i<n;i++) {
        		for(int j = 0;j<n;j++) {
        			if(arr[i][j]==1) {
        				visited = new boolean[n][n+2];
            			q.add(new int[] {i,j,0});
            			visited[i][j] = true;
            			cnt[i][j][0]++;
            			while(!q.isEmpty()) {
                    		int[] c = q.poll();
                    		if(c[2]==n+1) continue;
                    		for(int k =0;k<4;k++) {
                    			int cx = c[0]+dx[k];
                    			int cy = c[1]+dy[k];
                    			if(cx>=00&&cy>=0&&cx<n&&cy<n&&!visited[cx][cy]) {
                    				visited[cx][cy] = true;
                    				q.add(new int[] {cx,cy,c[2]+1});
                    				cnt[cx][cy][c[2]+1]++;
                    			}
                    		}
                    	}
        			}
        		}
        	}
        	int[] max = new int[n+2];
        	for(int i = 0;i<n;i++) {
        		for(int j = 0;j<n;j++) {
        			for(int k = 1;k<n+2;k++) {
        				cnt[i][j][k] += cnt[i][j][k-1];
        				max[k] = Math.max(max[k], cnt[i][j][k]);
        			}
        		}
        	}
        	int ans = 1;
        	for(int i = n+1;i>=2;i--) {
        		if(max[i-1]*m>=i*i+(i-1)*(i-1)) {
        			ans = max[i-1];
        			break;
        		}
        	}
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.print(sb);
	}
}