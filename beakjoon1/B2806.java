package beakjoon1;
import java.io.*;

public class B2806 {
	static int cnt;
	static int n;
	static boolean[][] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<t;i++	) {
			cnt = 0;
			n = Integer.parseInt(br.readLine());
			arr = new boolean[n+1][n+1];
			
			
			recursion(0);
			
			sb.append("#"+(i+1)+" "+cnt+"\n");
		}
		System.out.print(sb.toString().trim());
	}
	public static void recursion(int depth) {
		if(depth == n) {
			cnt++;
			return;
		}
		for(int i = 1; i<=n;i++) {
			if(possible(depth,i)) {
				arr[depth][i] = true;
				recursion(depth+1);
				arr[depth][i] = false;
			}
		}
		
		
	}
	public static boolean possible(int depth,int col) {
		for(int i = 1; i<=depth;i++) {
			if(arr[depth-i][col]) {
				return false;
			}
			if(col-i>=1&&arr[depth-i][col-i]) {
				return false;
			}
			if(col+i<=n&&arr[depth-i][col+i]) {
				return false;
			}
		}
		
		
		return true;
	}
}
