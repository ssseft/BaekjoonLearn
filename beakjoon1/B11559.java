package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B11559 {
	static boolean exist;
	static boolean[][] visited;
	static char[][] arr;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new char[12][6];
        
        for(int i = 0; i<12;i++) {
        	String line = br.readLine();
        	for(int j = 0;j<6;j++) {
        		arr[i][j] = line.charAt(j);
        	}
        }
        
        int stk = 0;
        
        while(true) {
        	exist = false;
        	visited = new boolean[12][6];
        	
        	//배열 탐색
        	for(int i = 0;i<12;i++) {
        		for(int j = 0;j<6;j++) {
        			if(!visited[i][j]&&arr[i][j]!='.') {
        				List<int[]> list = new ArrayList<>();
        				BFS(i,j,list);
        				if(list.size()>=4) {
        					for(int k = 0;k<list.size();k++) {
        						int x = list.get(k)[0];
        						int y = list.get(k)[1];
        						arr[x][y] = '.';
        						exist = true;
        					}
        				}
        			}
        		}
        	}
        	
        	move();
        	
        	if(exist) stk++;
        	else break;
        	
        }
        
        System.out.print(stk);
        
	}
	static void BFS(int x, int y,List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x,y});
		list.add(new int[] {x,y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int c[] = q.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=0&&cy>=0&&cx<12&&cy<6&&arr[cx][cy]==arr[x][y]&&!visited[cx][cy]) {
					q.add(new int[] {cx,cy});
					visited[cx][cy] = true;
					list.add(new int[] {cx,cy});
				}
			}
		}
	}
	static void move() {
		for(int i = 11;i>=1;i--) {
			for(int j = 0;j<6;j++) {
				if(arr[i][j]=='.') {
					for(int k = i;k>=0;k--) {
						if(arr[k][j]!='.') {
							arr[i][j] = arr[k][j];
							arr[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
}
