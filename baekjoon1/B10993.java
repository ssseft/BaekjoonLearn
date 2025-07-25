package beakjoon1;
import java.util.Scanner;

public class B10993 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		boolean[][] be= new boolean[1][1];
		be[0][0]= true;
		if(n==1) {
			System.out.print("*");
			return;
		}
		boolean[][] star = new boolean[(1<<n)-1][((1<<n)-1)*2-1];
		star = recursion(1,be);
		StringBuilder sb = new StringBuilder();
		if(n%2==1) {
			for(int i = 0;i<(1<<n)-1;i++) {
				for(int j = 0;j<((1<<n)-1)*2-1;j++) {
					if(star[i][j]) {
						sb.append('*');
					}
					else {
						sb.append(' ');
					}
				}
				if(i<((1<<n)-2)) {
			        sb.append('\n');
			    }
			}
		}
		else {
			for(int i = 0;i<(1<<n)-1;i++) {
				for(int j = 0;j<((1<<n)-1)*2-1;j++) {
					if(star[i][j]) {
						sb.append('*');
					}
					else {
						sb.append(' ');
					}
				}
				if(i<((1<<n)-2)) {
			        sb.append('\n');
			    }
			}
		}
		
		
		System.out.println(sb.toString());
	}
	static boolean[][] recursion(int size,boolean[][] before) {
		int cx = before.length*2+1;
		int cy = cx*2-1;
		
		boolean[][] star =new boolean[cx][cy];
	
		
		//홀수
		if((size+1)%2==1) {
			int left = cy/2;
			int right = cy/2;
			//외각
			for(int i = 0;i<cx;i++) {
				star[i][left--]= true;
				star[i][right++]= true;
			}
			//바닥
			for(int i = 0;i<cy;i++) {
				star[cx-1][i] = true;
			}
			//중앙
			int startx = cx/2;
			int starty = cx/2+1;
			for(int i = 0;i<before.length;i++) {
				for(int j = 0;j<before[0].length;j++) {
					star[startx+i][starty+j] = before[i][j];
				}
			}
		}
		else {
			int left = 0;
			int right = cy-1;
			//외각
			for(int i = 0;i<cx;i++) {
				star[i][left++]= true;
				star[i][right--]= true;
			}
			//하늘
			for(int i = 0;i<cy;i++) {
				star[0][i] = true;
			}
			//중앙
			int startx = 1;
			int starty = cx/2+1;
			for(int i = 0;i<before.length;i++) {
				for(int j = 0;j<before[0].length;j++) {
					star[startx+i][starty+j] = before[i][j];
				}
			}
		}
		
		if(size+1==n) {
			return star;
		}
		else {
			return recursion(size+1,star);
		}
	}
}
