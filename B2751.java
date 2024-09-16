package beakjun;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class B2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i =0; i<n; i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		Collections.sort(arr);
		
		
		StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append("\n");
        }
        System.out.print(sb);
		sc.close();
	}
}