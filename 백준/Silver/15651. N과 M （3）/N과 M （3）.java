import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        com(n, m, 0);
        System.out.print(sb);
    }

    public static void com(int n, int m, int des) {
        if (des == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[des] = i;
            com(n, m, des + 1);
        }
    }
}