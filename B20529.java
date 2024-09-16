package beakjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n > 32) {
                System.out.println(0);
                continue;
            }

            String[] arr = new String[n];
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }
            

            int min = Integer.MAX_VALUE;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    for (int c = b + 1; c < n; c++) {
                        int sum = 0;
                        for (int idx = 0; idx < 4; idx++) {
                            sum += arr[a].charAt(idx) != arr[b].charAt(idx) ? 1 : 0;
                            sum += arr[b].charAt(idx) != arr[c].charAt(idx) ? 1 : 0;
                            sum += arr[c].charAt(idx) != arr[a].charAt(idx) ? 1 : 0;
                        }
                        min = Math.min(sum, min);
                    }
                }
            }
            System.out.println(min);
        }
        br.close();
    }
}
