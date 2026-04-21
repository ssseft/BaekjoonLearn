import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i= 0;i<n;i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int d = sc.nextInt();
		int startidx = 0;
		int endidx = 0;
		for(int i = 0;i<n;i++) {
			if(arr[i]==d) {
				System.out.print(0);
				return;
			}
			if(d<arr[i]){
				endidx = arr[i];
				if(i==0) startidx = 0;
				else startidx = arr[i-1];
				break;
			}
		}
		
		int result = (d-startidx)*(endidx-d);
		System.out.println(result-1);
	}
}