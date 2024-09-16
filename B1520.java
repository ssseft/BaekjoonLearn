package beakjun;
import java.io.*;
import java.util.StringTokenizer;

public class B1520 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int m;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(st.nextToken());
			for(int j = 0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = DFS();
		
		
		
	}
	public static int DFS() {
		
		
		
		
		return 0;
	}
	
}
