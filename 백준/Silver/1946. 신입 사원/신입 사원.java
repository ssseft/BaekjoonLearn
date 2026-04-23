import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

            int minScore = 1000001;
            int count = 0;
            
            
            for (int j = 0; j < n; j++) {
                if (arr[j][1] < minScore) {
                    count++;
                    minScore = arr[j][1];
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}