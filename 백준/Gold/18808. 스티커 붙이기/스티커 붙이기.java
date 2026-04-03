import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		boolean[][] use = new boolean[n][m];
		for(int i = 0;i<s;i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			boolean[][] cur1 = new boolean[r][c];
			boolean[][] cur2 = new boolean[c][r];
			boolean[][] cur3 = new boolean[r][c];
			boolean[][] cur4 = new boolean[c][r];
			for(int j = 0;j<r;j++) {
				for(int k = 0;k<c;k++) {
					int w = sc.nextInt();
					if(w==1) {
						cur1[j][k] = true;
						cur2[k][r-1-j] = true;
						cur3[r-1-j][c-1-k] = true;
						cur4[c-1-k][j] = true;
					}
				}
			}
			boolean end = false;
			for(int j = 0;j<4;j++) {
				int cr,cc;
				boolean[][] cur;
				if(j==0) {
					cur = cur1;
					cr = r;
					cc = c;
				}
				else if(j==1) {
					cur=cur2;
					cr = c;
					cc = r;
				}
				else if(j==2) {
					cur = cur3;
					cr = r;
					cc = c;
				}
				else {
					cur = cur4;
					cr = c;
					cc = r;
				}
				
				for(int a = 0;a<n;a++) {
					if(end) break;
					for(int b = 0;b<m;b++) {
						boolean possible = true;
						
						for(int x = 0;x<cr;x++) {
							if(!possible) break;
							for(int y = 0;y<cc;y++) {
								if(!possible) break;
								if(a+x>=n||b+y>=m) {
									possible = false;
									break;
								}
								if(cur[x][y]&&use[a+x][b+y]) {
									possible = false;
									break;
								}
							}
						}
						if(possible) {
							for(int x = 0;x<cr;x++) {
								for(int y = 0;y<cc;y++) {
									if(cur[x][y]) {
										use[a+x][b+y] = true;
									}
								}
							}
							end = true;
							break;
						}
						
						
					}
					if(end) break;
				}
			}
			
			
			
		}
		int sum = 0;
		for(int i = 0;i<n;i++) {
			for(int j=  0;j<m;j++) {
				if(use[i][j]) sum++;
			}
		}
		System.out.print(sum);
	}
}
