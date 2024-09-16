package beakjun;
import java.io.*;
import java.util.StringTokenizer;

public class B15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n+1][3];
		int[] result = new int[n+2];
		for(int i = 1; i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i= n;i>0;i--) {
			if(i+arr[i][1]<=n+1) {
				result[i] = Math.max(result[i+1], arr[i][2]+result[i+arr[i][1]]);
			}
			else {
				result[i] = result[i+1];
			}
		}
		System.out.print(result[1]);
	}
}
