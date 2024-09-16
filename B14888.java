package beakjun;
import java.util.Scanner;

public class B14888 {
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int[] arr;
	public static int[] math;
	public static int n;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		math = new int[4];
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			math[i] = sc.nextInt();
		}
		
		DFS(math[0], math[1], math[2], math[3], 0, arr[0]);

        System.out.println(max);
        System.out.println(min);
		sc.close();
	}
	
	public static void DFS(int plus, int minus, int multiple, int divide, int x, int sum) {
        if (x == n - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        if (plus > 0) DFS(plus - 1, minus, multiple, divide, x + 1, sum + arr[x + 1]);
        if (minus > 0) DFS(plus, minus - 1, multiple, divide, x + 1, sum - arr[x + 1]);
        if (multiple > 0) DFS(plus, minus, multiple - 1, divide, x + 1, sum * arr[x + 1]);
        if (divide > 0) DFS(plus, minus, multiple, divide - 1, x + 1, sum / arr[x + 1]);
    }
}