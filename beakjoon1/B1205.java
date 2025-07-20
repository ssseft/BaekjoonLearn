package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B1205 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n  = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int list_num = Integer.parseInt(st.nextToken());
		
		if(n == 0) {
			System.out.print(1);
			return;
		}
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(arr[0]<newScore) {
			System.out.print(1);
			return;
		}
		if(arr[n-1]>newScore) {
			if(list_num==n) {
				System.out.print(-1);
			}
			else {
				System.out.print(n+1);
			}
			return;
		}
		for(int i = 0; i<n;i++) {
			if(arr[i]==newScore) {
				if(arr[n-1]==newScore&&n==list_num) {
					System.out.print(-1);
				}
				else {
					System.out.print(i+1);
				}
				return;
			}
			if(arr[i]<newScore) {
				System.out.print(i+1);
				return;
			}
			
		}
		System.out.print(-1);

	}
}