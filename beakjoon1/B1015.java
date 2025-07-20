package beakjoon1;

import java.util.Arrays;
import java.util.Scanner;

public class B1015 {
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
		int[] C = new int[n];
		boolean[] complete = new boolean[n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]&&!complete[j]) {
					B[j] = -1;
					C[j] = i;
					complete[j] = true;
					break;
				}
			}
		}

		for (int r : C) {
			System.out.print(r + " ");
		}
	}
}
