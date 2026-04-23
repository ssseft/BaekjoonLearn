import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : arr1) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr2) {
            sb.append(hash.getOrDefault(i, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());

        br.close();
    }
}