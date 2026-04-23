import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new boolean[n];
            dfs(0,0);
            System.out.println();
            
            
		}
	}
	
	private static void dfs(int start, int count) {
		if(count == 6) {
			for (int i = 0; i < n; i++) {
	            if (result[i]) {
	                System.out.print(arr[i] + " ");
	            }
	        }
            System.out.println();
            return;
		}
		
		for(int i =start; i<n; i++) {
			result[i] = true;
			dfs(i+1, count+1);
			result[i] = false;
		}
	}
}