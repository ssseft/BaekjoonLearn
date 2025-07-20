package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);
        reverse(arr, i, arr.length - 1);

        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
