package beakjun;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B1167 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][n];
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end==-1) {
					break;
				}
				arr[i][end]= Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<>();
		
		
		
		
	}
}
