package beakjun;
import java.util.Scanner;
import java.util.Arrays;

public class B1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int count = 0;
		Arrays.sort(arr, (e1,e2) ->{
			if(e1[1] == e2[1]) {
				return e1[0]-e2[0];
			}
			else {
				return e1[1]-e2[1];
			}
		});
		int endtime = 0;
		
		for(int i = 0; i<n; i++) {
			if(endtime<=arr[i][0]) {
				endtime = arr[i][1];
				count++;
			}
		}
		System.out.print(count);
		//이문제는 11650문제와 흡사함
		
	}
}
