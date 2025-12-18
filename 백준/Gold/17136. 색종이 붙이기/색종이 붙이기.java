import java.util.*;

public class Main {
	static int[][] arr;
	static int[] paper;
	static int total,min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		total = 0;
		for(int i = 0;i<10;i++) 
			for(int j = 0;j<10;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) total++;
			}
				
			
		paper = new int[6];
		min = 99;
		Arrays.fill(paper, 5);
		recur(0);
		if(min==99) System.out.print(-1);
		else System.out.print(min);
	}
	static void recur(int cnt) {
		if(total==0) {
			min = Math.min(min, cnt);
			return;
		}
		int x = 0;
		int y = 0;
		boolean s = false;
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<10;j++) {
				if(arr[i][j]==1) {
					x = i;
					y = j;
					s = true;
					break;
				}
			}
			if(s) break;
		}

		for(int i = 1;i<=5;i++) {
			if(x+i>10||y+i>10||paper[i]==0) continue;
			boolean ch = false;
			for(int j = x;j<x+i;j++) {
				for(int k = y;k<y+i;k++) {
					if(arr[j][k]==0) {
						ch = true;
						break;
					}
				}
				if(ch) break;
			}
			if(!ch) {
				for(int j = x;j<x+i;j++) {
					for(int k = y;k<y+i;k++) {
						arr[j][k] = 0;
					}
				}
				total-=i*i;
				paper[i]--;
				recur(cnt+1);
				paper[i]++;
				total+=i*i;
				for(int j = x;j<x+i;j++) {
					for(int k = y;k<y+i;k++) {
						arr[j][k] = 1;
					}
				}
			}
		}
	}
}
