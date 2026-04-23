import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] result = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = 9999999;
 
                if (i == j) {
                    result[i][j] = 0;
                }
            }
        }
        
        for(int i =0; i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	result[a][b] = Math.min(result[a][b], c);
        }
        
        
        for(int i = 1; i<n+1;i++) {
        	for(int j = 1; j<n+1;j++) {
        		for(int k =1;k<n+1;k++) {
        			if(result[j][i]+result[i][k]<result[j][k]) {
        				result[j][k] = result[j][i]+result[i][k];
        			}
        		}
        	}
        }
        
        
        
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<n+1;i++) {
			for(int j= 1; j<n+1;j++) {
				if(result[i][j] == 9999999) {
					result[i][j] = 0;
				}
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
