import java.util.*;

public class Main {
	static int[][] arr;
	static int[] paper;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		for(int i = 0;i<10;i++) 
			for(int j = 0;j<10;j++) {
				arr[i][j] = sc.nextInt();
			}
				
		paper = new int[6];
		min = 99;
		Arrays.fill(paper, 5);
		recur(0,0);
		if(min==99) System.out.print(-1);
		else System.out.print(min);
	}
	static void recur(int idx,int cnt) {
		if(idx==100) {
			min = Math.min(min, cnt);
			return;
		}
		int x = idx/10;
		int y = idx%10;
		if(arr[x][y]==0) recur(idx+1,cnt);
		else {
			for(int i = 1;i<=5;i++) {
				if(paper[i]<1||x+i>10||y+i>10) continue;
				boolean ch = true;
				for(int j = x;j<x+i;j++) {
					for(int k = y;k<y+i;k++) {
						if(arr[j][k]==0) {
							ch = false;
							break;
						}
					}
					if(!ch) break;
				}
				
				if(ch) {
					for(int j = x;j<x+i;j++) 
						for(int k = y;k<y+i;k++) 
							arr[j][k]--;
					paper[i]--;
					recur(idx+1,cnt+1);
					paper[i]++;
					for(int j = x;j<x+i;j++) 
						for(int k = y;k<y+i;k++) 
							arr[j][k]++;
				}
			}
		}
	}
}
