package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B3109 {
	static int n;
	static int m;
	static char[][] arr;
	static boolean[][] visited;
	static int cnt;
	static int[] dy = {-1,0,1};
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[m][n];
		for(int i = 0; i<n;i++) {
			String s = br.readLine();
			for(int j = 0; j<m;j++) {
				arr[j][i] = s.charAt(j);
			}
		}
		visited = new boolean[m][n];
		cnt = 0;
		check = false;
		for(int i =0; i<n;i++) {
			if(arr[0][i]!='x') {
				check = false;
				DFS(0,i);
			}
		}
		System.out.print(cnt);
	}
	public static void DFS(int x, int y) {
		if(x==m-1) {
			check = true;
			cnt++;
			return;
		}
		
		for(int i = 0; i<3;i++) {
			int cy = y+dy[i];
			if(x<m-1&&cy>=0&&cy<n&&!visited[x+1][cy]&&arr[x+1][cy]=='.') {
				visited[x+1][cy] = true;
				DFS(x+1,cy);
				if(check) return;
			}
		}
	}
}
