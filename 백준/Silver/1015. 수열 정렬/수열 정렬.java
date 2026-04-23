import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];

		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
			B[i] = A[i];
		}
		Arrays.sort(A);
		boolean[] used = new boolean[n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]&&!used[j]) {
					B[j] = i;
					used[j] = true;
					break;
				}
			}
		}

		for (int r : B) {
			System.out.print(r + " ");
		}
	}
}
