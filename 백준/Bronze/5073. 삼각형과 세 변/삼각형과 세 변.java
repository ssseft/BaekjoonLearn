import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0) break;
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			Arrays.sort(arr);
			
			if (arr[0] + arr[1] <= arr[2]) {
                sb.append("Invalid\n");
            } else if (arr[0] == arr[2]) {
                sb.append("Equilateral\n");
            } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
		}
		System.out.print(sb);
	}
}
