import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())] = i;
        }
        int count = 0;
        int max = 1;
        for(int i = 1; i<=n;i++) {
        	if(arr[i]>arr[i-1]) {
        		count++;
        		if(count>max) {
        			max = count;
        		}
        	}
        	else {
        		count = 1;
        	}
        }
        
        System.out.print(n-max);
    }
}
