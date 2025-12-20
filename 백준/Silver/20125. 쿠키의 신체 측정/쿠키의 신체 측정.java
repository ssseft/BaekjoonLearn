import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[][] arr = new char[n][n];
		int hx = 0;
		int hy = 0;
		boolean f = false;
		for(int i = 0;i<n;i++) {
			String l = sc.nextLine();
			for(int j = 0;j<n;j++) {
				arr[i][j] = l.charAt(j);
				if(!f&&arr[i][j]=='*') {
					f = true;
					hx = i+1;
					hy = j;
				}
			}
		}
		System.out.println((hx+1)+" "+(hy+1));
		
		int la = 0;
		for(int i = hy-1;i>=0;i--) {
			if(arr[hx][i]=='_') break;
			la++;
		}
		int ra = 0;
		for(int i = hy+1;i<n;i++) {
			if(arr[hx][i]=='_') break;
			ra++;
		}
		
		int waist = 0;
		int wx = hx;
		int wy = hy;
		
		for(int i = hx+1;i<n;i++) {
			if(arr[i][hy]=='_') break;
			waist++;
			wx++;
		}
		int ll = 0;
		for(int i = wx+1;i<n;i++) {
			if(arr[i][wy-1]=='_') break;
			ll++;
		}
		int rl = 0;
		for(int i = wx+1;i<n;i++) {
			if(arr[i][wy+1]=='_') break;
			rl++;
		}
		System.out.print(la+" "+ra+" "+waist+" "+ll+" "+rl);
	}
}