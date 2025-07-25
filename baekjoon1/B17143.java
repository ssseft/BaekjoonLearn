package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17143 {
	static int r,c;
	static int[][][] arr;
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[r+1][c+1][3];
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			arr[x][y][0] = s;
			arr[x][y][1] = d;
			arr[x][y][2] = size;
		}
		
		int score = 0;
		
		for(int j=1;j<c+1;j++) {
			//물고기 잡기
			for(int i=1;i<r+1;i++) {
				if(arr[i][j][2]!=0) {
					score += arr[i][j][2];
					arr[i][j][0] = 0;
					arr[i][j][1] = 0;
					arr[i][j][2] = 0;
					break;
				}
			}
			//상어 이동
			arr = shark();
		}
		
		System.out.print(score);
	}
	static int[][][] shark() {
		int[][][] newarr = new int[r+1][c+1][3];
		for(int i = 1;i<r+1;i++) {
			for(int j = 1;j<c+1;j++) {
				if(arr[i][j][2]!=0) {
					int[] c = move(i,j,arr[i][j][0],arr[i][j][1]);
					if(newarr[c[0]][c[1]][2]<arr[i][j][2]) {
						newarr[c[0]][c[1]][0] = arr[i][j][0];
						newarr[c[0]][c[1]][1] = c[2];
						newarr[c[0]][c[1]][2] = arr[i][j][2];
					}
				}
			}
		}
		return newarr;
	}
	
	static int[] move(int y, int x, int speed, int dir) {
        int newY = y, newX = x, newDir = dir;
        
        for (int i=0;i<speed; i++) {
            int ny = newY+dy[newDir];
            int nx = newX+dx[newDir];

            while(ny<1||ny>r||nx<1||nx>c) {  
                if(newDir<=2) newDir = (newDir==1)?2:1;
                else newDir = (newDir==3)?4:3;
                ny = newY + dy[newDir];
                nx = newX + dx[newDir];
            }
            newY = ny;
            newX = nx;
        }
        
        return new int[]{newY, newX, newDir};
    }
}
