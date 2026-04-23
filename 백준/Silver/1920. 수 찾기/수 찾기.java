import java.util.Scanner;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] A = new int[a];
		for(int i =0; i<a; i++) {
			A[i]= sc.nextInt();
		}
		int b = sc.nextInt();
		int[] B = new int[b];
		for(int i =0; i<b; i++) {
			B[i] = sc.nextInt();
		}
		sc.close();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < a; i++) {
            set.add(A[i]);
        }
		
		for (int i = 0; i < b; i++) {
            if (set.contains(B[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
	}
}
