import java.util.*;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr[] = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int x = n/2;
		int y = n/2;
		int dis = 1;
		int cnt = 0;
		int ans = 0;
		int d = 0;
		while(dis<=n) {
			for(int i = 0;i<dis;i++) {
				int cx = x+dx[d];
				int cy = y+dy[d];
				if(x==0&&y==0) break;
				int total = arr[cx][cy];
				arr[cx][cy] = 0;
				cx += dx[d];
				cy += dy[d];
				
				int x1 = cx+dx[d];
				int y1 = cy+dy[d];
				if(s(x1,y1)) arr[x1][y1] += total/20;
				else ans += total/20;
				
				int x2 = cx+dx[(d+1)%4];
				int y2 = cy+dy[(d+1)%4];
				if(s(x2,y2)) arr[x2][y2] += total/10;
				else ans += total/10;
				
				int x3 = cx+dx[(d+3)%4];
				int y3 = cy+dy[(d+3)%4];
				if(s(x3,y3)) arr[x3][y3] += total/10;
				else ans += total/10;
				
				cx -= dx[d];
				cy -= dy[d];
				
				int x4 = cx+dx[(d+1)%4];
				int y4 = cy+dy[(d+1)%4];
				if(s(x4,y4)) arr[x4][y4] += (int)Math.floor(total*0.07);
				else ans += (int)Math.floor(total*0.07);
				
				int x5 = cx+dx[(d+3)%4];
				int y5 = cy+dy[(d+3)%4];
				if(s(x5,y5)) arr[x5][y5] += (int)Math.floor(total*0.07);
				else ans += (int)Math.floor(total*0.07);
				
				int x6 = x4+dx[(d+1)%4];
				int y6 = y4+dy[(d+1)%4];
				if(s(x6,y6)) arr[x6][y6] += total/50;
				else ans += total/50;
				
				int x7 = x5+dx[(d+3)%4];
				int y7 = y5+dy[(d+3)%4];
				if(s(x7,y7)) arr[x7][y7] += total/50;
				else ans += total/50;
				
				int x8 = x+dx[(d+1)%4];
				int y8 = y+dy[(d+1)%4];
				if(s(x8,y8)) arr[x8][y8] += total/100;
				else ans += total/100;
				
				int x9 = x+dx[(d+3)%4];
				int y9 = y+dy[(d+3)%4];
				if(s(x9,y9)) arr[x9][y9] += total/100;
				else ans += total/100;
				
				total -= ((total/100)*2+(total/50)*2+(int)Math.floor(total*0.07)*2+(total/10)*2+(total/20));
				
				if(s(cx+dx[d],cy+dy[d])) arr[cx+dx[d]][cy+dy[d]] += total;
				else ans += total;
				
				x = cx;
				y = cy;
			}
			if(x==0&&y==0) break;
			cnt++;
			d = (d+1)%4;
			
			if(cnt==2) {
				cnt = 0;
				dis ++;
			}
		}
		System.out.print(ans);
	}
	static boolean s(int x, int y) {
		if(x>=0&&y>=0&&x<n&y<n) return true;
		else return false;
	}
}