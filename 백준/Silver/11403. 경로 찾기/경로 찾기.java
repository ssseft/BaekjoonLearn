import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
		
		for(int i = 0; i<n;i++) {
			for(int j = 0;j<n;j++) {
				for(int k =0;k<n;k++) {
					if(arr[j][i]+arr[i][k]==2) {
						arr[j][k] = 1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<n;i++) {
			for(int j= 0; j<n;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}