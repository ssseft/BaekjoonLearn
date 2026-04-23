import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int[] nums;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        com(n, m, 0);

        sc.close();
    }

    public static void com(int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int used = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && nums[i] != used) {
                visited[i] = true;
                arr[depth] = nums[i];
                com(n, m, depth + 1);
                visited[i] = false;
                used = nums[i];
            }
        }
    }
}