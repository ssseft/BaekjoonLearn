package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20061 {
	static boolean[][] blue,green;
	static int score = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		blue = new boolean[6][4];
		green = new boolean[6][4];
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			block(x,y,t);
			remove();
			gravity();
			move();
		}
		int cnt = 0;
		for(int i = 0;i<6;i++) {
			for(int j = 0;j<4;j++) {
				if(blue[i][j]) cnt++;
				if(green[i][j]) cnt++;
			}
		}
		System.out.println(score);
		System.out.println(cnt);
	}
	static void move() {
		boolean gr0 = false;
		boolean gr1 = false;
		boolean bl0 = false;
		boolean bl1 = false;
		
		for(int i = 0;i<4;i++) {
			if(green[0][i]) gr0 = true;
			if(green[1][i]) gr1 = true;
			if(blue[0][i]) bl0 = true;
			if(blue[1][i]) bl1 = true;
		}
		
		for(int i = 5;i>=2;i--) {
			for(int j = 0;j<4;j++) {
				if(gr0) {
					green[i][j] = green[i-2][j];
				}
				else if(gr1) {
					green[i][j] = green[i-1][j];
				}
				
				if(bl0) {
					blue[i][j] = blue[i-2][j];
				}
				else if(bl1) {
					blue[i][j] = blue[i-1][j];
				}
			}
		}
		for(int i = 0;i<4;i++) {
			blue[0][i] = false;
			blue[1][i] = false;
			green[0][i] = false;
			green[1][i] = false;
		}
	}
	static void gravity() {
		boolean bcon = false;
		boolean gcon = false;
		for(int i = 5;i>=2;i--) {
			boolean bl = false;
			boolean gr = false;
			for(int j = 0;j<4;j++) {
				if(blue[i][j]) bl = true;
				if(green[i][j]) gr = true;
			}
			if(!bcon&&!bl) {
				boolean nextline = false;
				for(int j = 0;j<4;j++) if(blue[i-1][j]) nextline = true;
				for(int j = i;j>=2;j--) {
					for(int k = 0;k<4;k++) {
						if(!nextline) blue[j][k] = blue[j-2][k];
						else blue[j][k] = blue[j-1][k];
					}
				}
				if(!nextline){
	                for(int k = 0; k<4;k++) {
	                    blue[0][k] = false;
	                    blue[1][k] = false;
	                }
	            }
				else{
	                for(int k = 0; k<4;k++) {
	                    blue[1][k] = false;
	                }
	            }
				bcon = true;
			}
			if(!gcon&&!gr) {
				boolean nextline = false;
				for(int j = 0;j<4;j++) if(green[i-1][j]) nextline = true;
				for(int j = i;j>=2;j--) {
					for(int k = 0;k<4;k++) {
						if(!nextline) green[j][k] = green[j-2][k];
						else green[j][k] = green[j-1][k];
					}
				}
				if(!nextline){
	                for(int k = 0;k<4;k++) {
	                    green[0][k] = false;
	                    green[1][k] = false;
	                }
	            }
				else{
	                for(int k = 0;k<4;k++) {
	                    green[1][k] = false;
	                }
	            }
				gcon = true;
			}
		}
	}
	static void remove() {
		for(int i = 2;i<6;i++) {
			boolean bl = false;
			boolean gr = false;
			for(int j = 0;j<4;j++) {
				if(!blue[i][j]) bl = true; 
				if(!green[i][j]) gr = true;
			}
			if(!bl) {
				for(int j=  0;j<4;j++) {
					blue[i][j] = false;
				}
				score++;
			}
			if(!gr) {
				for(int j = 0;j<4;j++) {
					green[i][j] = false;
				}
				score++;
			}
		}
	}
	static void block(int x, int y,int t) {
		boolean gr = false;
		boolean bl = false;
		for(int i = 2;i<6;i++) {
			if(t==2&&green[i][y+1]) {
				green[i-1][y] = true;
				green[i-1][y+1] = true;
				gr = true;
				break;
			}
			if(green[i][y]) {
				green[i-1][y] = true;
				if(t==3) green[i-2][y] = true;
				if(t==2) green[i-1][y+1] = true;
				gr = true;
				break;
			}
		}
		if(!gr) {
			green[5][y] = true;
			if(t==3) green[4][y] = true;
			if(t==2) green[5][y+1] = true;
		}
		
		for(int i = 2;i<6;i++) {
			if(t==3&&blue[i][x+1]) {
				blue[i-1][x] = true;
				blue[i-1][x+1] = true;
				bl = true;
				break;
			}
			if(blue[i][x]) {
				blue[i-1][x] = true;
				if(t==3) blue[i-1][x+1] = true;
				if(t==2) blue[i-2][x] = true;
				bl = true;
				break;
			}
		}
		if(!bl) {
			blue[5][x] = true;
			if(t==2) blue[4][x] = true;
			if(t==3) blue[5][x+1] = true;
		}
	}
}
