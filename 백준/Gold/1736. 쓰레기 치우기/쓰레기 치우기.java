import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i= 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(arr[i][j]==1) {
					cnt++;
					search(i,j);
				}
			}
		}
		
		System.out.print(cnt);
	}
	static void search(int x, int y) {
		for(int i = y;i<m;i++) {
			if(arr[x][i]==1) {
				arr[x][i]=0;
				search(x,i);
				return;
			}
		}
		
		if(x+1<n) {
			search(x+1,y);
		}
	}
}
