import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weight = new int[N];
		int[] value = new int[N];
		for(int i =0; i<N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		sc.close();
		int result = knapSack_dp(K,weight,value,N);
		System.out.print(result);
		
		
		
	}
	
	public static int knapSack(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n-1] > W) {
            return knapSack(W, wt, val, n-1);
        } else {
            int valWithout = knapSack(W, wt, val, n-1);
            int valWith = val[n-1] + knapSack(W - wt[n-1], wt, val, n - 1);
            return Math.max(valWith, valWithout);
        }
    }

    public static int knapSack_dp(int W, int[] wt, int[] val, int n) {
        int[][] A = new int[n + 1][W + 1];

        for (int i =1;i<=n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i-1] >w) {
                    A[i][w] = A[i-1][w];
                } else {
                    int valWith = val[i-1] + A[i-1][w -wt[i-1]];
                    int valWithout = A[i-1][w];
                    A[i][w] = Math.max(valWith, valWithout);
                }
            }
        }

        return A[n][W];
    }
}