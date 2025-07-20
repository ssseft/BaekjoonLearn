package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19236 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] field = new int[4][4];
		int[][] direction = new int[4][4];
		for(int i = 0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<4;j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				field[i][j] = num;
				direction[i][j] = dir;
			}
		}
		int score = 0;
		max = 0;
		int[] shark = new int[3];
		shark[0] = 0;
		shark[1] = 0;
		shark[2] = direction[0][0];
		score += field[0][0];
		max += field[0][0];
		field[0][0] = 100;
		move(field,direction);
		search(score,field,direction,shark);
		System.out.println(max);
	}
	static void search(int score,int[][] field,int[][] direction,int[] shark) {
		int sharkx = shark[0];
		int sharky = shark[1];
		int sharkdir = shark[2];
		
		for(int i = 1;i<4;i++) {
			int cx = sharkx+dx[sharkdir]*i;
			int cy = sharky+dy[sharkdir]*i;
			
			if(cx>=0&&cy>=0&&cx<4&&cy<4&&field[cx][cy]!=0) {
				int[][] newarr = new int[4][4];
				int[][] newdir = new int[4][4];
				for(int j = 0;j<4;j++) {
					newarr[j] = field[j].clone();
					newdir[j] = direction[j].clone();
				}
				int[] newshark = shark.clone();
				
				int tempscore = field[cx][cy];
				score+=tempscore;
				field[sharkx][sharky] = 0;
				field[cx][cy] = 100;
				shark[0] = cx;
				shark[1] = cy;
				shark[2] = direction[cx][cy];
				
				max = Math.max(max, score);
				
				move(field,direction);
				search(score,field,direction,shark);
				
				for(int j = 0;j<4;j++) {
					field[j] = newarr[j].clone();
					direction[j] = newdir[j].clone();
				}
				shark = newshark.clone();
				
				score-=tempscore;
				shark[0] = sharkx;
				shark[1] = sharky;
				shark[2] = sharkdir;
				field[cx][cy] = tempscore;
				field[sharkx][sharky] = 100;
				
			}
		}
		
	}
	static void move(int[][] field,int[][] direction){
		boolean ch;
		int idx = 1;
		while(idx<17) {
			ch = false;
			for(int i = 0;i<4;i++) {
				for(int j = 0;j<4;j++) {
					if(field[i][j]==idx) {
						int x = i;
						int y = j;
						int dir = direction[i][j];
						int cx = 0;
						int cy = 0;
						int cnt = 0;
						while(cnt<8) {
							cx = x+dx[dir];
							cy = y+dy[dir];
							if(cx>=0&&cy>=0&&cx<4&&cy<4&&field[cx][cy]>=0&&field[cx][cy]<17) {
								break;
							}
							dir = (dir+1)%8;	
							cnt++;
						}
						if(cnt!=8) {
							int temp = field[x][y];
							int dtemp = dir;
							field[x][y] = field[cx][cy];
							field[cx][cy] = temp;
							direction[x][y] = direction[cx][cy];
							direction[cx][cy] = dtemp;
						}
						ch = true;
					}
					if(ch) break;
				}
				if(ch) break;
			}
			idx++;
		}
	}
}
