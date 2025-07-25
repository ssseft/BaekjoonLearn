package beakjoon1;

import java.util.Scanner;

public class C1244_1{
    static int N;
    static int max = 0;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            N = sc.nextInt();
            arr = new int[s.length()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.charAt(i) - '0';
            }

            if (arr.length < N) {
                N = arr.length;
            }

            DFS(0);

            System.out.println("#" + test_case + " " + max);
            max = 0;
        }
    }

    static void DFS(int depth) {
        if (depth == N) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result += (Math.pow(10, i) * arr[arr.length - i - 1]);
            }

            max = Math.max(result, max);

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                DFS(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}