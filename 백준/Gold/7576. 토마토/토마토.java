import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int[][] arr = new int[x][y];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};

		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i<x; i++) {
			for(int j = 0; j<y; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					q.add(new int[]{i,j,0});
				}
			}
		}
		int count = 0;
		
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int day = current[2];
            
            count = day;

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(0 <= nx && nx <x && 0<= ny && ny <y) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.add(new int[] {nx,ny,day+1});
                    }
                }
            }
        }

        boolean check = false;
        for(int i = 0; i<x; i++) {
        	for(int j = 0; j<y; j++) {
        		if(arr[i][j] == 0) {
        			check = true;
        			break;
        		}
        	}
        	if(check) {
        		break;
        	}
        }
		if(!check) {
			System.out.print(count);
		}
		else {
			System.out.print(-1);
		}
	}
}
