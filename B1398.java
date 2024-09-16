package beakjun;
import java.io.*;
import java.util.StringTokenizer;

public class B1398 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		int max = 1000000;
		for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = max;
 
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
		for(int i =0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start-1][end-1] = 1;
			arr[end-1][start-1] = 1;
		}
		for(int i =0; i<n;i++) {
			for(int j =0;j<n;j++) {
				for(int k =0;k<n;k++) {
					if(arr[j][k]>arr[j][i]+arr[i][k]) {
						arr[j][k] = arr[j][i]+arr[i][k];
					}
				}
			}
		}
		
		int result = 0;
		for(int i =0; i<n;i++) {
			int sum= 0;
			for(int j=0;j<n;j++) {
				sum+=arr[i][j];
			}
			if(max>sum) {
				max = sum;
				result= i;
			}
		}
		System.out.print(result+1);
	}
}
