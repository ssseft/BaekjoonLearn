package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2146 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static Queue<int[]> q2;
	static int[][] arr;
	static int groundidx;
	static int[][] field;
	static boolean[][] visitedground;
	static Queue<int[]> q;
	static List<List<int[]>> clusters;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		clusters = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		groundidx = 1;
		q = new LinkedList<>();
		visitedground = new boolean[n][n];
		field = new int[n][n];
		q2 = new LinkedList<>();
		
		for(int i = 0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(arr[i][j]==1&&!visitedground[i][j]) {
					groundidx++;
					q.add(new int[] {i,j});
					visitedground[i][j] = true;
					field[i][j] = groundidx;
					List<int[]> list = new ArrayList<>();
					list.add(new int[]{i, j});
					bfs(list);
					clusters.add(list);
				}
			}
		}
		int answer = calcDistance(clusters);
		
		System.out.print(answer);
	}
	static void bfs(List<int[]> cluster) {
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<n&&cy<n&&arr[cx][cy]==1) {
					if(!visitedground[cx][cy]) {
						visitedground[cx][cy] = true;
						q.add(new int[] {cx,cy});
						field[cx][cy] = groundidx;
						cluster.add(new int[]{cx, cy});
					}
				}
			}
		}
	}
	static int calcDistance(List<List<int[]>> clusters) {
        int min = Integer.MAX_VALUE;

        for (int i = 0;i<clusters.size();i++) {
            for (int j = i + 1; j<clusters.size(); j++) {
                for (int[] p1:clusters.get(i)) {
                    for (int[] p2:clusters.get(j)) {
                        int dist = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1])-1;
                        min = Math.min(min,dist);
                    }
                }
            }
        }
        return min;
    }
}
