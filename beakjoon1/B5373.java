package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5373 {
	static char[][][] cube;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		char[][][] stan = new char[6][3][3];
		for(int i = 0;i<3;i++) {
			Arrays.fill(stan[0][i], 'w');
			Arrays.fill(stan[1][i], 'y');
			Arrays.fill(stan[2][i], 'g');
			Arrays.fill(stan[3][i], 'b');
			Arrays.fill(stan[4][i], 'r');
			Arrays.fill(stan[5][i], 'o');
		}
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			cube = new char[6][3][3];
			for(int i = 0;i<6;i++) {
			    for(int j = 0;j<3;j++) {
			        cube[i][j]=Arrays.copyOf(stan[i][j], 3);
			    }
			}
			// 편의상 1~6 면, 1~9번호로 고정
			//위 w  아래 y  왼 g  오 b  앞 r  뒤 o로 고정
			boolean c;
			
			for(int i = 0;i<n;i++) {
				String line = st.nextToken();
				char dir = line.charAt(0);
				char clock = line.charAt(1);
				int a = -1;
				
				if(clock=='+') c = true;
				else {
					c = false;
				}
				if(dir=='U') a = 0;
				if(dir=='D') a = 1;
				if(dir=='L') a = 2;
				if(dir=='R') a = 3;
				if(dir=='F') a = 4;
				if(dir=='B') a = 5;
				cal(a,c);
			}
			
			
			for(int i = 0;i<=2;i++) {
				for(int j = 0;j<=2;j++) {
					sb.append(cube[0][i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString().trim());
	}
	static void cal(int dir,boolean clock) {
		char[][] arr = new char[5][5];
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				arr[i+1][j+1] = cube[dir][i][j];
			}
		}
		if(dir==0) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[5][0][2-i];
				arr[i+1][4] = cube[3][0][2-i];
				arr[i+1][0] = cube[2][0][i];
				arr[4][i+1] = cube[4][0][i];
				
			}
		}
		if(dir==1) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[5][2][i];
				arr[i+1][4] = cube[2][2][i];
				arr[i+1][0] = cube[3][2][2-i];
				arr[4][i+1] = cube[4][2][2-i];
			}
		}
		if(dir==2) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[0][i][0];
				arr[i+1][4] = cube[4][i][0];
				arr[i+1][0] = cube[5][i][2];
				arr[4][i+1] = cube[1][i][2];
			}
		}
		if(dir==3) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[0][2-i][2];
				arr[i+1][4] = cube[5][i][0];
				arr[i+1][0] = cube[4][i][2];
				arr[4][i+1] = cube[1][2-i][0];
			}
		}
		if(dir==4) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[0][2][i];
				arr[i+1][4] = cube[3][i][0];
				arr[i+1][0] = cube[2][i][2];
				arr[4][i+1] = cube[1][2][2-i];
			}
		}
		if(dir==5) {
			for(int i = 0;i<3;i++) {
				arr[0][i+1] = cube[0][0][2-i];
				arr[i+1][4] = cube[2][i][0];
				arr[i+1][0] = cube[3][i][2];
				arr[4][i+1] = cube[1][0][i];
			}
		}
		
		char[][] s = new char[5][5];
		
		s = rotation(arr,clock);
		
		if(dir==0) {
			for(int i = 0;i<3;i++) {
				cube[5][0][2-i] = s[0][i+1];
				cube[3][0][2-i] = s[i+1][4];
				cube[2][0][i] = s[i+1][0];
				cube[4][0][i] = s[4][i+1];
			}
		}
		if(dir==1) {
			for(int i = 0;i<3;i++) {
				cube[5][2][i] = s[0][i+1];
				cube[2][2][i] = s[i+1][4];
				cube[3][2][2-i] = s[i+1][0];
				cube[4][2][2-i] = s[4][i+1];
			}
		}
		if(dir==2) {
			for(int i = 0;i<3;i++) {
				cube[0][i][0] = s[0][i+1];
				cube[4][i][0] = s[i+1][4];
				cube[5][i][2] = s[i+1][0];
				cube[1][i][2] = s[4][i+1];
			}
		}
		if(dir==3) {
			for(int i = 0;i<3;i++) {
				cube[0][2-i][2] = s[0][i+1];
				cube[5][i][0] = s[i+1][4];
				cube[4][i][2] = s[i+1][0];
				cube[1][2-i][0] = s[4][i+1];
				
			}
		}
		if(dir==4) {
			for(int i = 0;i<3;i++) {
				cube[0][2][i] = s[0][i+1];
				cube[3][i][0] = s[i+1][4];
				cube[2][i][2] = s[i+1][0];
				cube[1][2][2-i] = s[4][i+1];
			}
		}
		if(dir==5) {
			for(int i = 0;i<3;i++) {
				cube[0][0][2-i] = s[0][i+1];
				cube[2][i][0] = s[i+1][4];
				cube[3][i][2] = s[i+1][0];
				cube[1][0][i] = s[4][i+1];
			}
		}
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		        cube[dir][i][j] = s[i + 1][j + 1];
		    }
		}
	}
	static char[][] rotation(char[][] arr,boolean clock){
		char[][] result = new char[5][5];
		if(clock) {
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<5;j++) {
					if((i==0||i==4)&&(j==0||j==4)) {
						continue;
				}
					result[i][j] = arr[4-j][i];
				}
			}
		}
		else {
			for(int i = 0;i<5;i++) {
				for(int j = 0;j<5;j++) {
					if((i==0||i==4)&&(j==0||j==4)) {
							continue;
					}
					result[i][j] = arr[j][4-i];
				}
			}
		}
		return result;
	}
}
