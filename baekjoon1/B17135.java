package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17135 {
	static int n,m,d;
	static int[][] arr;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0;j<m;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        int max = 0;
        List<int[]> archerlist = ArcherPosition(m);
        
        for(int i = 0;i<archerlist.size();i++) {
        	int[][] field = new int[n][m];
        	for (int a = 0; a < n; a++) {
        	    field[a] = arr[a].clone();
        	}

        	int s = 0;
        	int[] archer = archerlist.get(i);
        	for(int j = 0;j<n;j++) {
        		s += attack(archer,field);
        		move(field);
        	}
        	max = Math.max(max, s);
        	
        }
        
        System.out.print(max);
        
	}
	static void move(int[][] field) {
		for(int i = n-1;i>=1;i--) {
			for(int j =0;j<m;j++) {
				field[i][j] = field[i-1][j];
			}
		}
		for (int j = 0; j < m; j++) {
	        field[0][j] = 0;
	    }
	}
	static int[] search(int archer,int[][] field) {
		int[] target;
		int distance = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n-1,archer});
		boolean[][] visited = new boolean[n][m];
		visited[n-1][archer] = true;
		if(field[n-1][archer]==1) {
			target = new int[] {n-1,archer};
			return target;
		}
		while(!q.isEmpty()&&distance<d) {
			int size = q.size();
			for(int k = 0;k<size;k++) {
				int[] c = q.poll();
				for(int i = 0;i<3;i++) {
					int cx = c[0]+dx[i];
					int cy = c[1]+dy[i];
					if(cx>=0&&cy>=0&&cx<n&&cy<m&&!visited[cx][cy]) {
						if(field[cx][cy]==1) {
							target = new int[] {cx,cy};
							return target;
						}
						else {
							visited[cx][cy] = true;
							q.add(new int[] {cx,cy});
						}
					}
				}
			}
			distance++;
		}
		return null;
	}
	static int attack(int[] archer,int[][] field) {
		List<int[]> attacklist = new ArrayList<>();
		int score = 0;
		for(int a : archer) {
			attacklist.add(search(a,field));
		}
		
		for(int[] b : attacklist) {
			if(b!=null) {
				if(field[b[0]][b[1]]==1) {
					score++;
				}
				field[b[0]][b[1]] = 0;
			}
		}
		return score;
	}
	
	static List<int[]> ArcherPosition(int m) {
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0;i<m-2;i++) {
			for(int j = i+1;j<m-1;j++) {
				for(int k = j+1;k<m;k++) {
					list.add(new int[] {i,j,k});
				}
			}
		}
		return list;
	}
}
