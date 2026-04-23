import java.util.*;

public class Main {
	static boolean possible;
	static int[][] match = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5}, {2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb=  new StringBuilder();
		
		arr = new int[6][3];
		
		for(int k = 0;k<4;k++) {
			int w = 0;
			int d = 0;
			int l = 0;
			possible = false;
			boolean ch = true;
			for(int i = 0;i<6;i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
				w+=arr[i][0];
				d+=arr[i][1];
				l+=arr[i][2];
				if(arr[i][0]+arr[i][1]+arr[i][2]!=5) ch = false;
			}
			
			if(w!=l||!ch||d%2!=0) {
				possible = false;
			}
			else {
				recur(0);
			}
			
			if(possible) {
				sb.append(1+" ");
			}
			else {
				sb.append(0+" ");
			}
		}
		System.out.print(sb);
	}
	static void recur(int cnt) {
		if(possible) return;
		
		if(cnt==15) {
			possible = true;
			return;
		}
		
		int a = match[cnt][0];
		int b = match[cnt][1];
		
		if(arr[a][0]>0&&arr[b][2]>0) {
			arr[a][0]--;
			arr[b][2]--;
			recur(cnt+1);
			arr[a][0]++;
			arr[b][2]++;
		}
		
		if(arr[a][2]>0&&arr[b][0]>0) {
			arr[a][2]--;
			arr[b][0]--;
			recur(cnt+1);
			arr[a][2]++;
			arr[b][0]++;
		}
		
		if(arr[a][1]>0&&arr[b][1]>0) {
			arr[a][1]--;
			arr[b][1]--;
			recur(cnt+1);
			arr[a][1]++;
			arr[b][1]++;
		}
	}
}