package beakjoon1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		sc.close();
		int[] chess= {1,1,2,2,2,8};
		for(int i = 0;i<6;i++) {
			int c = Integer.parseInt(st.nextToken());
			int result = chess[i]-c;
			sb.append(result+" ");
		}
		System.out.print(sb.toString().trim());
	}
}
