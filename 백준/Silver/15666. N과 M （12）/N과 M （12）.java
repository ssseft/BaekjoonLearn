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
        int[] num = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        
        nums = Arrays.stream(num).distinct().sorted().toArray();
        com(n, m, 0, 0);

        sc.close();
    }

    public static void com(int n, int m, int depth,int start) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < nums.length; i++) {
            arr[depth] = nums[i];
            com(n, m, depth + 1, i);
        }
    }
}