import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		total = 0;
		int ans = recur(n,0,0);
		
		System.out.println(total-ans);
		System.out.println(ans);
		
	}
	static int recur(int size,int x,int y) {
		if(size==1) {
			total++;
			if(arr[x][y]==1) return 1;
			else return 0;
		}
		
		boolean ch = true;
		for(int i = x;i<x+size;i++) {
			for(int j = y;j<y+size;j++) {
				if(arr[x][y]!=arr[i][j]) {
					ch = false;
					break;
				}
			}
			if(!ch) break;
		}
		
		if(!ch) {
			return 
			(recur(size/2,x,y)+
			recur(size/2,x+size/2,y)+
			recur(size/2,x,y+size/2)+
			recur(size/2,x+size/2,y+size/2));		
		}
		else {
			total++;
			if(arr[x][y]==1) return 1;
			else return 0;
		}
	}

}
