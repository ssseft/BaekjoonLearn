package beakjoon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 시작 시간 기록
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // Step 1: Calculate prefix sums
            int[] prefixSum = new int[n + 1];
            for (int j = 0; j < n; j++) {
                prefixSum[j + 1] = prefixSum[j] + arr[j];
            }

            // Step 2: Calculate left_max
            int[] left_max = new int[n];
            int max_sum = 0;
            for (int j = k - 1; j < n; j++) {
                int current_sum = prefixSum[j + 1] - prefixSum[j + 1 - k];
                if (current_sum > max_sum) {
                    max_sum = current_sum;
                }
                left_max[j] = max_sum;
            }

            // Step 3: Calculate right_max
            int[] right_max = new int[n];
            max_sum = 0;
            for (int j = n - k; j >= 0; j--) {
                int current_sum = prefixSum[j + k] - prefixSum[j];
                if (current_sum > max_sum) {
                    max_sum = current_sum;
                }
                right_max[j] = max_sum;
            }

            // Step 4: Find the maximum sum of two non-overlapping subarrays
            int max_total = 0;
            for (int j = k - 1; j <= n - 2 * k; j++) {
                max_total = Math.max(max_total, left_max[j] + right_max[j + 1]);
            }

            sb.append("#").append(i).append(" ").append(max_total).append("\n");
        }

        System.out.print(sb.toString().trim());

        // 종료 시간 기록
        long endTime = System.currentTimeMillis();

        // 실행 시간 출력
        System.out.println("\nExecution Time: " + (endTime - startTime) + " ms");
    }
}
