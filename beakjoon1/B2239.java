package beakjoon1;
import java.io.*;
public class B2239 {
	static int[][] arr;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[9];
		arr = new int[9][9];
		
		for(int i = 0; i<9;i++) {
			s[i] = br.readLine();
			for(int j = 0; j<9;j++) {
				arr[i][j]= s[i].charAt(j)-'0';
			}
		}
		
		check = false;
		cal(0);
		
		for(int i = 0; i<9;i++) {
			for(int j =0; j<9;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	public static void cal(int num) {
		if(num==81) {
			check = true;
			return;
		}
		
		if(check) return;
		
		int x = num/9;
		int y = num%9;
		
		if(arr[x][y]!=0) {
			cal(num+1);
		}
		
		else {
			for(int i = 1; i<10;i++) {
				if(possible(x,y,i)) {
					arr[x][y] = i;
					cal(num+1);
					if(check) return;
					arr[x][y] = 0;
				}
			}
		}
	}
	public static boolean possible(int x, int y,int num) {
		int box_x = (x/3)*3;
		int box_y = (y/3)*3;
		
		for(int i = 0; i<9;i++) {
			if(num==arr[x][i]) {
				return false;
			}
		}
		
		for(int i = 0; i<9;i++) {
			if(num==arr[i][y]) {
				return false;
			}
		}
		
		for(int i = box_x;i<box_x+3;i++) {
			for(int j = box_y;j<box_y+3;j++) {
				if(num==arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}