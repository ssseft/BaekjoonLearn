package beakjoon1;

import java.util.LinkedList;
import java.util.Queue;

public class P2 {
	public static void main(String[] args) {
		int[][] rectangle = {
			    {2,2,5,5},
			    {1,3,6,4},
			    {3,1,4,6}
			};

		System.out.println(solution(rectangle,1,4,6,3));
	}
	static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][][] road = new boolean[51][51][2];
        // 0우 1상
        for(int i = 0;i<rectangle.length;i++) {
        	int[] c = rectangle[i];
        	int x1 = c[0];
        	int y1 = c[1];
        	int x2 = c[2];
        	int y2 = c[3];
        	for(int j = x1;j<x2;j++) {
        		road[j][y1][0] = true;
        		road[j][y2][0] = true;
        	}
        	for(int j = y1;j<y2;j++) {
        		road[x1][j][1] = true;
        		road[x2][j][1] = true;
        	}
        }
        for(int i = 0;i<rectangle.length;i++) {
        	int[] c = rectangle[i];
        	int x1 = c[0];
        	int y1 = c[1];
        	int x2 = c[2];
        	int y2 = c[3];
        	for(int j = x1+1;j<x2;j++) {
        		for(int k = y1+1;k<y2;k++) {
        			road[j][k][0] = false;
        			road[j-1][k][0] = false;
        			road[j][k][1] = false;
        			road[j][k-1][1] = false;
        		}
        	}
        	
        	if(y2-y1==1) {
                for(int x=x1+1;x<x2;x++) {
                    road[x][y1][1] = false;
                }
            }

            if(x2-x1 == 1) {
                for(int y=y1+1;y<y2;y++) {
                    road[x1][y][0] = false;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {characterX,characterY});
        boolean search = false;
        boolean[][] visited = new boolean[51][51];
        visited[characterX][characterY] = true;
        //우 좌 하 상
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i =0;i<size;i++) {
        		int[] c = q.poll();
        		int x = c[0];
        		int y = c[1];
        		if(x==itemX&&y==itemY) {
        			search = true;
        			break;
        		}
        		//왼
        		if(x>=2&&road[x-1][y][0]&&!visited[x-1][y]) {
        			visited[x-1][y] = true;
    				q.add(new int[]{x-1,y});
        		}
        		if(x<50&&road[x][y][0]&&!visited[x+1][y]) {
        			visited[x+1][y] = true;
    				q.add(new int[]{x+1,y});
        		}
        		if(y>=2&&road[x][y-1][1]&&!visited[x][y-1]) {
        			visited[x][y-1] = true;
        			q.add(new int[] {x,y-1});
        		}
        		if(y<50&&road[x][y][1]&&!visited[x][y+1]) {
        			visited[x][y+1] = true;
        			q.add(new int[] {x,y+1});
        		}
        	}
        	if(search) break;
        	answer++;
        }
        
        return answer;
	}
}
