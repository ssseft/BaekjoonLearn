import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = j + 1;
            }
            for(int j = 0; j < K; j++) {
                for(int k = 1; k < N; k++) {
                    arr[k] += arr[k - 1];
                }
            }
            System.out.println(arr[N - 1]);
        }
        sc.close();
    }
}