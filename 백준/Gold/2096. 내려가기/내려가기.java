import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][4];
		StringTokenizer st;
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<4;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] maxdp = new int[n][4];
		int[][] mindp = new int[n][4];
		maxdp[0][1] = mindp[0][1] = arr[0][1];
		maxdp[0][2] = mindp[0][2] = arr[0][2];
		maxdp[0][3] = mindp[0][3] = arr[0][3];
		for(int i =1 ;i<n;i++) {
			for(int j =1;j<4;j++) {
				if(j==1) {
					maxdp[i][j] = Math.max(maxdp[i-1][j], maxdp[i-1][j+1]) + arr[i][j];
					mindp[i][j] = Math.min(mindp[i-1][j], mindp[i-1][j+1]) + arr[i][j];
				}
				else if(j==2) {
					int abmax = Math.max(maxdp[i-1][j-1], maxdp[i-1][j]);
					int abmin = Math.min(mindp[i-1][j-1], mindp[i-1][j]);
					maxdp[i][j] = Math.max(abmax, maxdp[i-1][j+1]) + arr[i][j];
					mindp[i][j] = Math.min(abmin, mindp[i-1][j+1]) + arr[i][j];
				}
				else {
					maxdp[i][j] = Math.max(maxdp[i-1][j-1], maxdp[i-1][j]) + arr[i][j];
					mindp[i][j] = Math.min(mindp[i-1][j-1], mindp[i-1][j]) + arr[i][j];
				}
			}
		}
		int resultmax0 =  Math.max(maxdp[n-1][1], maxdp[n-1][2]);
		int resultmin0 =  Math.min(mindp[n-1][1], mindp[n-1][2]);
		int resultmax = Math.max(resultmax0, maxdp[n-1][3]);
		int resultmin = Math.min(resultmin0, mindp[n-1][3]);
		System.out.print(resultmax+" "+resultmin);
	}
}
